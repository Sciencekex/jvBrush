package Daily1t

fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
    val counts = mutableListOf<Int>()

    for (row in mat) {
        var count = 0
        for (num in row) {
            if (num == 1) count++
        }
        counts.add(count)
    }

    val maxValue = counts.maxOrNull() ?: 0
    val maxIndex = counts.indexOf(maxValue)

    return intArrayOf(maxIndex, maxValue)
}