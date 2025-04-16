package Daily1t

fun judgePrime(n: Int): Boolean {
    if (n <= 1) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    val sqrtN = Math.sqrt(n.toDouble()).toInt()
    for (i in 3..sqrtN step 2) {
        if (n % i == 0) return false
    }
    return true
}

fun getDiagonalElements(matrix: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()
    val n = matrix.size
    for (i in 0..n-1) {
        result.add(matrix[i][i])
    }
    for (i in 0..n-1) {
        if (i != n-i-1) {
            result.add(matrix[i][n-i-1])
        }
    }
    return result
}

fun diagonalPrime(nums: Array<IntArray>): Int {
    val judgeList = getDiagonalElements(nums)
    var maxPrime = 0
    for (n in judgeList) {
        if (judgePrime(n)) {
            maxPrime = maxOf(maxPrime, n)
        }
    }
    return maxPrime
}