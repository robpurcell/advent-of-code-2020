package day03

import java.io.File

fun main() {
    val map = """
        |..##.......
        |#...#...#..
        |.#....#..#.
        |..#.#...#.#
        |.#...##..#.
        |..#.##.....
        |.#.#.#....#
        |.#........#
        |#.##...#...
        |#...##....#
        |.#..#...#.#
    """.trimMargin()

    println("Number of trees encountered in small map: ${findCoordinates(map.split("\n").toMutableList(), Pair(3,1))}")
    println("Number of trees encountered in large map: ${findCoordinates(readInput(), Pair(3,1))}")

    println(traverse(map.split("\n").toMutableList(), mutableListOf(Pair(1, 1), Pair(3,1), Pair(5,1), Pair(7, 1), Pair(1, 2))))
    println(traverse(readInput(), mutableListOf(Pair(1, 1), Pair(3,1), Pair(5,1), Pair(7, 1), Pair(1, 2))))
}

fun traverse(map: MutableList<String>, coords: MutableList<Pair<Int, Int>>): Long {
    var product: Long = 1
    for (c in coords) {
        val numberOfTrees = findCoordinates(map, c)
        println(numberOfTrees)
        product = product * numberOfTrees
    }
    return product
}

fun readInput(path: String = "/Users/rob/Development/source/github/advent-of-code-2020/src/test/resources/day03-input.txt"): MutableList<String> {
    val file = File(path)
    return file.readLines().toMutableList() //.map { parseRecord(it) }
}

fun findCoordinates(map: MutableList<String>, vector: Pair<Int, Int>, startingCoords: Pair<Int, Int> = Pair(0,0)): Int {
    var x = startingCoords.first
    var y = startingCoords.second
    var count = 0

    while (y < map.size) {
        if (map[y][x] == '#')
            count++

        x += vector.first
        y += vector.second

        if (y >= map.size)
            continue

        while (map[y].length <= x)
            map[y] = map[y] + map[y]

    }
    return count
}




