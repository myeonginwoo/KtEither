package main.kotlin

/**
 * Created by Lazysoul on 2016. 12. 14..
 */
sealed class Either<L, R> {

    var isLeft: Boolean = false
    var isRight: Boolean = false

    var left: LeftProjection<L, Nothing>? = null
    var right: RightProjection<Nothing, R>? = null

    class Left<L, R>(val value: L) : Either<L, R>() {
        init {
            isLeft = true
            left = LeftProjection(value)
        }
    }

    class Right<L, R>(val value: R) : Either<L, R>() {
        init {
            isRight = true
            right = RightProjection(value)
        }
    }

    fun <X> fold(fLeft: (L) -> X, fRight: (R) -> X): X {
        return when (this) {
            is Left -> fLeft(value)
            is Right -> fRight(value)
        }
    }
}