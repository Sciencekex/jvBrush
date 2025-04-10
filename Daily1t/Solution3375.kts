package Daily1t

fun minOperations(nums: IntArray, k: Int): Int {
    val numbers = mutableListOf<Int>()
    for (num in nums) {
        if (num < k) {
            return -1
        } else if (num > k) {
            numbers.add(num)
        }
    }
    return numbers.toSet().size
}