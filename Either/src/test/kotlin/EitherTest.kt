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
        val eitherLeft: Either<String, Int> = Left("test")
        assertEquals("test", eitherLeft.left?.get)
        assertEquals(true, eitherLeft.isLeft)
        assertEquals(false, eitherLeft.isRight)
    }

    @Test fun rightTest() {
        val rightEither: Either<String, Int> = Right(6)
        assertEquals(6, rightEither.right?.get)
        assertEquals(false, rightEither.isLeft)
        assertEquals(true, rightEither.isRight)
    }

    @Test fun tryTest() {
        val stringValue = "test"
        val either: Either<String, Int> = try {
            Right(stringValue.toInt())
        } catch (e: Exception) {
            Left(e.toString())
        }

        assertEquals(true, either.isLeft)
        assertEquals(false, either.isRight)
    }

    @Test fun leftMapTest() {
        val either: Either<String, Int> = Left("123")

        assertEquals(123, either.left?.map(String::toInt)?.get)
        assertEquals("123test", either.left?.map { it + "test" }?.get)
    }

    @Test fun rightMapTest() {
        val either: Either<String, Int> = Right(123)

        assertEquals(123.0, either.right?.map(Int::toDouble)?.get)
        assertEquals(246, either.right?.map { it * 2 }?.get)
    }

    @Test fun leftFilterTest() {
        val either: Either<String, Int> = Left("left")

        assertEquals(either.left?.filter { it.length > 3 }, "left")
        assertEquals(either.left?.filter { it.length > 5 }, null)
        assertEquals(either.left?.filter { it.length > 5 } ?: "default", "default")
    }

    @Test fun rightFilterTest() {
        val either: Either<String, Int> = Right(126)

        assertEquals(either.right?.filter { it > 100 }, 126)
        assertEquals(either.right?.filter { it < 100 }, null)
        assertEquals(either.right?.filter { it < 100 } ?: -1, -1)
    }
}