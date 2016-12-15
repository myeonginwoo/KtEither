package main.kotlin

/**
 * Created by Lazysoul on 2016. 12. 15..
 */
class RightProjection<out L, out R>(val value: R) {

    val get: R get() = value

    fun <X : Any> map(f: (R) -> X): RightProjection<L, X> {
        return RightProjection(f(value))
    }
}