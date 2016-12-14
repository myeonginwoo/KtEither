package main.kotlin

/**
 * Created by Lazysoul on 2016. 12. 14..
 */
sealed class Either<L : Any, R : Any> {

    var isLeft: Boolean = false
    var isRight: Boolean = false

    var left: Left<L, Nothing>? = null
    var right: Right<Nothing, R>? = null
    abstract fun get(): Any

    class Left<L : Any, R : Any>(val value: L) : Either<L, R>() {
        init {
            isLeft = true
        }

        override fun get(): L {
            return value
        }

    }

    class Right<L : Any, R : Any>(val value: R) : Either<L, R>() {
        init {
            isRight = true
        }

        override fun get(): R {
            return value
        }
    }
}