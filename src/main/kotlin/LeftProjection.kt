package main.kotlin

/**
 * Created by Lazysoul on 2016. 12. 15..
 */
class LeftProjection<out L, out R>(val value: L) {

    val get: L get() = value

    fun <X> map(f: (L) -> X): LeftProjection<X, R> {
        return LeftProjection(f(value))
    }

    fun filter(predicate: (L) -> Boolean): LeftProjection<L, R>? {
        return if (predicate(value)) {
            return LeftProjection(value)
        } else {
            null
        }
    }

    fun exists(f: (L) -> Boolean): Boolean {
        return f(value)
    }

    fun <X, R1> flatMap(f: (L) -> Either<X, R1>): Either<X, R1> {
        return f(value)
    }
}