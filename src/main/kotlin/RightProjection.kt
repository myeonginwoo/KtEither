package main.kotlin

/**
 * Created by Lazysoul on 2016. 12. 15..
 */
class RightProjection<out L, out R>(val value: R) {

    val get: R get() = value

    fun <X : Any> map(f: (R) -> X): RightProjection<L, X> {
        return RightProjection(f(value))
    }

    fun filter(predicate: (R) -> Boolean): RightProjection<L, R>? {
        return if (predicate(value)) {
            return RightProjection(value)
        } else {
            null
        }
    }

    fun exists(f: (R) -> Boolean): Boolean {
        return f(value)
    }

    fun <L1, X> flatMap(f: (R) -> Either<L1, X>): Either<L1, X> {
        return f(value)
    }
}