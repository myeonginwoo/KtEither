package main.kotlin

/**
 * Created by Lazysoul on 2016. 12. 15..
 */
class LeftProjection<out L,out R>(val value: L) {

    val get: L get() = value

    fun <X> map(f: (L) -> X): LeftProjection<X, R> {
        return LeftProjection(f(value))
    }

    fun filter(predicate: (L) -> Boolean) : L? {
        return if(predicate(value)) {
            return value
        } else {
            null
        }
    }
}