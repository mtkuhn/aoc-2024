import java.io.File

fun readInput(name: String) = File("src/main/resources/", "$name.txt")
    .readLines()

fun readTestInput(name: String) = File("src/test/resources/", "$name.txt")
    .readLines()