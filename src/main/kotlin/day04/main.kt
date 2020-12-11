package day04

import java.io.File
import java.util.regex.Pattern

fun main() {
    val batchFile = """
|ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
|byr:1937 iyr:2017 cid:147 hgt:183cm
|
|iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
|hcl:#cfa07d byr:1929
|
|hcl:#ae17e1 iyr:2013
|eyr:2024
|ecl:brn pid:760753108 byr:1931
|hgt:179cm
|
|hcl:#cfa07d eyr:2025 pid:166559648
|iyr:2011 ecl:brn hgt:59in
    """.trimMargin()

    val passports = processBatchFile(batchFile)
    println("Number of valid passwords: ${validate(passports)}")

    val passportsFile = processBatchFile(readInput())
    println("Number of valid passwords: ${validate(passportsFile)}")
}

fun validate(passports: List<Map<String, String>>): Int {
    var count = 0
    for (p in passports) {
        if (validateEcl(p.get("ecl")) &&
            validatePid(p.get("pid")) &&
            validateEyr(p.get("eyr")) &&
            validateHcl(p.get("hcl")) &&
            validateByr(p.get("byr")) &&
            validateIyr(p.get("iyr")) &&
            validateHgt(p.get("hgt"))) {
                count++
        }
    }
    return count
}

fun validateHgt(s: String?): Boolean {
    return when {
        s?.endsWith("in") == true -> {
            val value = s.substring(0, s.length - 2).toInt()
            value in 59..76
        }
        s?.endsWith("cm") == true -> {
            val value = s.substring(0, s.length - 2).toInt()
            value in 150..193
        }
        else -> false
    }
}

fun validateIyr(s: String?): Boolean {
    return s != null && s.toInt() >= 2010 && s.toInt() <= 2020
}

fun validateByr(s: String?): Boolean {
    return s != null && s.toInt() >= 1920 && s.toInt() <= 2002
}

fun validateHcl(s: String?): Boolean {
    return s?.length == 7 && s.matches(Regex("[#][0-9a-f]{6}"))
}

fun validateEyr(s: String?): Boolean {
    return s != null && s.toInt() >= 2020 && s.toInt() <= 2030
}

fun validatePid(s: String?): Boolean {
    return s?.length == 9 && s.matches(Regex("[0-9]{9}"))
}

fun validateEcl(s: String?): Boolean {
    return "amb blu brn gry grn hzl oth".split(" ").contains(s)
}

fun processBatchFile(batchFile: String): List<Map<String, String>> {
    val records = batchFile.split("\n\n")
    val passports = emptyList<Map<String, String>>().toMutableList()

    for (r in records) {
        val entries = r.replace('\n', ' ').split(" ")
        val fields = emptyMap<String, String>().toMutableMap()
        for (e in entries) {
            val split = e.split(":")
            fields.put(split[0], split[1])
        }
        passports.add(fields)
    }

    return passports
}

fun readInput(path: String = "/Users/rob/Development/source/github/advent-of-code-2020/src/test/resources/day04-input.txt"): String {
    val file = File(path)
    return file.readText().trimEnd()
}
