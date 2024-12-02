import kotlin.math.absoluteValue

fun main() {
    val input = readInput("Day01")
    val testInput = readTestInput("Day01")
    println(day1part1(testInput))
    println(day1part1(input))
    println(day1part2(testInput))
    println(day1part2(input))
}

fun day1part1(input: List<String>): Int {
    val left = input.listLeft().sorted()
    val right = input.listRight().sorted()
    return left.zip(right).sumOf { (it.first - it.second).absoluteValue }
}

fun day1part2(input: List<String>): Int {
    val left = input.listLeft().sorted()
    val right = input.listRight().sorted()
    val rFreq = right.frequencyMap()
    return left.sumOf { it * (rFreq[it] ?: 0) }
}

fun List<String>.listLeft() = map { it.split("\\s+".toRegex())[0].toInt() }
fun List<String>.listRight() = map { it.split("\\s+".toRegex())[1].toInt() }
fun List<Int>.frequencyMap() = fold(mutableMapOf<Int, Int>()) { acc, i -> acc.apply { acc[i] = (acc[i]?:0)+1 } }