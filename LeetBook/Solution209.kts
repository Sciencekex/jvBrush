fun minSubArrayLen(target: Int, nums: IntArray): Int {
    val length = nums.size - 1
    var min = Int.MAX_VALUE
    for (slow in 0..length) {
        for (fast in slow until length) {
            val sum = nums.slice(slow..fast).sum()
            if (sum >= target) {
                val temp = fast - slow + 1
                if (temp < min) min = temp
            }
        }
    }
    if (min == Int.MAX_VALUE) min = 0
    return min
}

println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
