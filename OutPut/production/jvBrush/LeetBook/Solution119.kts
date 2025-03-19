fun getRow(rowIndex: Int): List<Int> {
    if (rowIndex == 0) return mutableListOf<Int>(1)
    val result = mutableListOf<List<Int>>()
    result.add(listOf(1))
    for (row in 1 until rowIndex+1) {
        val previousRow = result[row - 1]
        val currentRow = mutableListOf<Int>()
        currentRow.add(1)
        for (j in 1 until row) {
            currentRow.add(previousRow[j - 1] + previousRow[j])
        }
        currentRow.add(1)
        result.add(currentRow)
    }
    return result[rowIndex]
}

println(getRow(0))