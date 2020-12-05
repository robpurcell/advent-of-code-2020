package day02

import java.io.File

fun main() {
    """
        |1-3 a: abcde
        |1-3 b: cdefg
        |2-9 c: ccccccccc
    """.trimIndent()

    println("Day 2.1 - Number of valid passwords: ${readInput().map { validateRangePolicy(it.first, it.second) }.count { b -> b }}")

    """
        1-3 a: abcde is valid: position 1 contains a and position 3 does not.
        1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
        2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c
    """.trimIndent()

    println("Day 2.2 - Number of valid passwords: ${readInput().map { validateOccurrencePolicy(it.first, it.second) }.count { b -> b }}")

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

fun validateRangePolicy(policy: Policy, password: String): Boolean {
    val countOfLetter = password.count { c -> c == policy.letter }
    return countOfLetter >= policy.min && countOfLetter <= policy.max
}

fun validateOccurrencePolicy(policy: Policy, password: String): Boolean =
    (password[policy.min - 1] == policy.letter).xor(password[policy.max - 1] == policy.letter)
