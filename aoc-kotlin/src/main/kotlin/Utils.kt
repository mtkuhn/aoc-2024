import java.io.File

fun readInput(name: String) = File("./resources/main/", "$name.txt").readLines()
fun readTestInput(name: String) = File("./resources/test/", "$name.txt").readLines()