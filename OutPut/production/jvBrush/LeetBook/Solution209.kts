//209. 长度最小的子数组
//中等
//相关标签
//相关企业
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//
//示例 1：
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//示例 2：
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//示例 3：
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//提示：
//
//1 <= target <= 109
//1 <= nums.length <= 105
//1 <= nums[i] <= 104
//
//
//进阶：
//
//如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var minLength = Int.MAX_VALUE
    var left = 0
    var sum = 0
    for (right in nums.indices) {
        sum += nums[right] // 扩展窗口
        while (sum >= target) {
            minLength = minOf(minLength, right - left + 1) // 更新最小长度
            sum -= nums[left] // 收缩窗口
            left++
        }
    }
    return if (minLength == Int.MAX_VALUE) 0 else minLength
}

println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
