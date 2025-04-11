package Daily1t

fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
    var result = 0
    for (command in commands) {
        result += when(command) {
            "UP" -> -n
            "RIGHT" -> 1
            "DOWN" -> n
            "LEFT" -> -1
            else -> 0
        }
    }
    return result
}