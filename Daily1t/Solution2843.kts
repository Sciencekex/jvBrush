package Daily1t

fun judgeSymmetricInteger(num: Int): Boolean {
    val numStr = num.toString()
    val numLength = numStr.length
    if (numLength % 2 != 0) {return false}
    val halfLength = numLength / 2
    return (numStr.substring(0, halfLength).map{it.toString().toInt()}.sum() == numStr.substring(halfLength, numLength).map{it.toString().toInt()}.sum())
}

fun countSymmetricIntegers(low: Int, high: Int): Int {
    var count = 0
    for (num in low..high) {
        if (judgeSymmetricInteger(num)) count+=1
    }
    return count
}