package Daily1t

fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    val result = mutableListOf<Triple<Int, Int, Int>>()
    for (i in 0..arr.size-3 ) {
        for (j in i+1..arr.size-2 ) {
            for (k in j+1..arr.size-1 ) {
                result.add(Triple(arr[i],arr[j],arr[k]))
            }
        }
    }
    val finalResult = mutableListOf<Triple<Int, Int, Int>>()
    for (r in result) {
        val (i,j,k) = r
        if (Math.abs(i - j) <= a &&
            Math.abs(j - k) <= b &&
            Math.abs(i - k) <= c) {
            finalResult.add(r)
        }
    }
    return finalResult.size
}