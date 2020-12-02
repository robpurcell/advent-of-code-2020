package day02

import java.io.File

fun main() {
    """
        |1-3 a: abcde
        |1-3 b: cdefg
        |2-9 c: ccccccccc
    """.trimIndent()

    println("Number of valid passwords; ${readInput().map { validatePolicy(it.first, it.second) }.count { b -> b }}")
}

private fun readInput(path: String = "/Users/rob/Development/source/github/advent-of-code-2020/src/test/resources/day02-input.txt"): List<Pair<Policy, String>> {
    val file = File(path)
    return file.readLines().map { parseRecord(it) }
}

fun parseRecord(input: String): Pair<Policy, String> {
    val split = input.split(" ")
    val minMax = split[0].split("-")
    val min = minMax[0].toInt()
    val max = minMax[1].toInt()
    val letter = split[1][0]
    val policy = Policy(min, max, letter)
    val password = split[2]

    return Pair(policy, password)
}

data class Policy(val min: Int, val max: Int, val letter: Char)

fun validatePolicy(policy: Policy, password: String): Boolean {
    val countOfLetter = password.count { c -> c == policy.letter }
    return countOfLetter >= policy.min && countOfLetter <= policy.max
}
