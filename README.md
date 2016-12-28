# KtEither
Kotlin Either Lib

inProgress...

Left
```kotlin
val eitherLeft: Either<String, Int> = Left("test")
println(eitherLeft.left?.get)   // "test"
```

Right
```kotlin
val rightEither: Either<String, Int> = Right(6)
println(rightEither.right?.get) // 6

```

try-catch
```kotlin
val stringValue = "test"
val either: Either<String, Int> = try {
    Right(stringValue.toInt())
} catch (e: Exception) {
    Left(e.toString())
}
```

fold
```kotlin
val leftEither: Either<String, Int> = Left("test")
println(leftEither.fold({ "Left is $it" }, { it * 3 }))  // "Left is test"

val rightEither: Either<String, Int> = Right(6)
pirntln(rightEither.fold({ "Left is $it" }, { it * 3 })) // 18)
```

map
```kotlin
//left
val either: Either<String, Int> = Left("123")
println(either.left?.map(String::toInt)?.get)   // 123

   
//right
val either: Either<String, Int> = Right(123)
println(either.right?.map(Int::toDouble)?.get)  // 123.0
```

filter
```kotlin
//left
val either: Either<String, Int> = Left("left")
println(either.left?.filter { it.length > 3 }.get)  //left
println(either.left?.filter { it.length < 3 }.get)  //null

//right
val either: Either<String, Int> = Right(126)
println(either.right?.filter { it > 100 }?.get)     //126
println(either.right?.filter { it < 100 }?.get)     //null
```
