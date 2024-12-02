
fun main() {
    val input = readInput("Day02")
    val testInput = readTestInput("Day02")
    println(day2part1(testInput))
    println(day2part1(input))
    println(day2part2(testInput))
    println(day2part2(input))
}

fun List<Int>.isProgressingWithinBounds(bounds: IntRange, hasDampener: Boolean): Boolean {
    var usedDampener = false

    //there's a case we missed where the first one may need to be removed
    if(hasDampener && this.drop(1).isProgressingWithinBounds(bounds, false)) return true

    var prev = this.first()
    for(curr in this.drop(1)) {
        if(bounds.contains(curr - prev)) {
            prev = curr
        } else {
            if(hasDampener && !usedDampener) usedDampener = true
            else return false
        }
    }

    //todo: I'm missing something here, short by 1 in the result in part 2

    return true
}

fun List<Int>.isSafe(hasDampener: Boolean = false) =
    isProgressingWithinBounds(1 .. 3, hasDampener) ||
            isProgressingWithinBounds( -3 .. -1, hasDampener)

fun day2part1(input: List<String>): Int {
    return input.map { it.split(" ").map { it.toInt() } }
        .count { it.isSafe() }
}

fun day2part2(input: List<String>): Int {
    return input.map { it.split(" ").map { it.toInt() } }
        .count { it.isSafe(true) }
}


