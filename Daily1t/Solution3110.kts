package Daily1t

import kotlin.math.abs

fun scoreOfString(s: String): Int {
    val asciiList:MutableList<Int> = mutableListOf()
    for (char in s) {
        asciiList.add(char.code)
    }
    var result = 0
    for (i in 0 .. asciiList.size-2 ) {
        result += abs(asciiList[i]-asciiList[i+1])
    }
    return result
}
