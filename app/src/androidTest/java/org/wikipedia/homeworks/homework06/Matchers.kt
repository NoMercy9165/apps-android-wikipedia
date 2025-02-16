package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Test


enum class Color {
    RED, GREEN, BLUE, YELLOW, BLACK, WHITE
}


data class Shape(val sideLength: Float, val sides: Int, val color: Color)


//Проверка длины стороны в заданном диапазоне
class SideLengthMatcher(private val min: Float, private val max: Float) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("has side length between $min and $max")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength in min..max
    }
}

fun hasSideLengthInRange(min: Float, max: Float) = SideLengthMatcher(min, max)


//Проверка на наличие отрицательного количества сторон
class NonNegativeSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("number of sides cannot be negative")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sides >= 0
    }
}

fun hasNonNegativeSides() = NonNegativeSidesMatcher()


//Проверка на наличие отрицательной длины стороны
class NegativeSideLengthMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("side length cannot be negative")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength >= 0
    }
}

fun hasNegativeSideLength() = NegativeSideLengthMatcher()


//Проверка на чётное количество сторон.
class EvenSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("number of sides must be even")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sides % 2 == 0 && item.sides > 2
    }
}

fun hasEvenSides() = EvenSidesMatcher()


//Проверка количества углов
class CornersMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("shape should have correct number of corners")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sides >= 3
    }

}

fun hasCorrectCorners() = CornersMatcher()

//Проверка цвета фигуры.
class ColorMatcher(private val expectedColor: Color) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("shape should be $expectedColor")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.color == expectedColor
    }

}

fun hasColor(color: Color) = ColorMatcher(color)


class ShapeMatcherTest {

    @Test
    fun shouldCorrectlyMatchVariousShapes() {
        val shapes = listOf(
            Shape(5f, 3, Color.RED),
            Shape(10f, 4, Color.GREEN),
            Shape(7f, 4, Color.BLUE),
            Shape(3f, 3, Color.YELLOW),
            Shape(10f, 5, Color.BLACK),
            Shape(15f, 6, Color.WHITE),
            Shape(2f, 4, Color.RED),
            Shape(4f, 8, Color.GREEN),
            Shape(6f, 10, Color.BLUE),
            Shape(1f, 2, Color.YELLOW),
            Shape(1f, 1, Color.BLACK),
            Shape(10f, 3, Color.WHITE),
            Shape(-5f, 4, Color.RED),
            Shape(10f, -4, Color.GREEN),
            Shape(-10f, -4, Color.BLUE),
            Shape(5f, 0, Color.YELLOW),
            Shape(0f, 3, Color.BLACK),
            Shape(7f, 7, Color.WHITE),
            Shape(3f, 6, Color.RED)
        )

        shapes.forEach { shape ->
            // Проверка корректных фигур с длиной стороны в диапазоне от 1 до 20
            if (shape.sideLength in 1f..20f && shape.sides > 2) {
                assertThat(shape, hasSideLengthInRange(1f, 20f))
                assertThat(shape, hasNonNegativeSides())
                assertThat(shape, hasCorrectCorners())
                assertThat(shape, not(hasNegativeSideLength()))
            }

            // Проверка на некорректные фигуры с отрицательными значениями
            if (shape.sideLength < 0) {
                assertThat(shape, hasNegativeSideLength()) // Отрицательная длина стороны
            }
            if (shape.sides < 0) {
                assertThat(shape, not(hasNonNegativeSides())) // Отрицательное количество сторон
            }

            // Проверка фигур с 1 и 2 сторонами
            if (shape.sides == 1 || shape.sides == 2) {
                assertThat(shape, not(hasCorrectCorners())) // У таких фигур нет углов
                assertThat(shape, not(hasEvenSides()))     // Проверка на четность, такие фигуры не могут быть четными
            }

            // Проверка на корректное количество сторон для четных фигур (больше 2)
            if (shape.sides > 2 && shape.sides % 2 == 0) {
                assertThat(shape, hasEvenSides())
            }

            // Проверка на корректный цвет
            assertThat(shape, hasColor(shape.color))
        }
    }
}