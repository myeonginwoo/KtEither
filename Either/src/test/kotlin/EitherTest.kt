package test.kotlin

import main.kotlin.Either
import main.kotlin.Either.Left
import main.kotlin.Either.Right
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Lazysoul on 2016. 12. 14..
 */
class EitherTest {

    @Test fun leftTest() {
        val left: Either<String, Int> = Left("test")
        assertEquals("test", left.get())
        assertEquals(true, left.isLeft)
        assertEquals(false, left.isRight)
        assertEquals(null, left.right?.get())
    }

    @Test fun rightTest() {
        val right: Either<String, Int> = Right(6)
        assertEquals(6, right.get())
        assertEquals(false, right.isLeft)
        assertEquals(true, right.isRight)
        assertEquals(null, right.left?.get())
    }
}