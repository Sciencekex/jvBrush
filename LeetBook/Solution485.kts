//485. 最大连续 1 的个数
//已解答
//简单
//相关标签
//相关企业
//提示
//给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
//
//
//
//示例 1：
//
//输入：nums = [1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
//示例 2:
//
//输入：nums = [1,0,1,1,0,1]
//输出：2
//
//
//提示：
//
//1 <= nums.length <= 105
//nums[i] 不是 0 就是 1.

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    val length = nums.size - 1
    var slow = 0
    var max = 0
    for (fast in 0..length) {
        if (nums[fast] == 0 || fast == length) {
            val temp = if (nums[fast] == 0) fast - slow else fast - slow + 1
            if (temp >= max) {
                max = temp
            }
            slow = fast + 1
        }
    }
    return max
}

println(findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0, 1)))