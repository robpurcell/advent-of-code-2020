package day01

import java.io.File

fun main() {
    println("Product: ${calc(readInput())}")
    println("Product: ${calcThree(readInput())}")
}

private fun calc(numbers: List<Int>, target: Int = 2020): Int {
    for (n in numbers) {
        for (m in numbers) {
            if (n + m == target) {
                val product = n * m
                print("n: $n, m: $m\n")
                return product
            }
        }
    }
    return 0
}

private fun calcThree(numbers: List<Int>, target: Int = 2020): Int {
    for (n in numbers) {
        for (m in numbers) {
            for (o in numbers) {
                if (n + m + o == target) {
                    val product = n * m * o
                    print("n: $n, m: $m, o: $o\n")
                    return product
                }
            }
        }
    }
    return 0
}

private fun readInput(path: String = "/Users/rob/Development/source/github/advent-of-code-2020/src/test/resources/day01-input.txt"): List<Int> {
    val file = File(path)
    return file.readLines().map { it.toInt() }.sorted()
}
