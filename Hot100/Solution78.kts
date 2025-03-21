//78. 子集
//中等
//相关标签
//相关企业
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//示例 2：
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//提示：
//
//1 <= nums.length <= 10
//-10 <= nums[i] <= 10
//nums 中的所有元素 互不相同
fun subsets(nums: IntArray): List<List<Int>> {
    val sets = mutableListOf<List<Int>>()
    sets.add(emptyList())

    for (num in nums) {
        val newSubsets = mutableListOf<List<Int>>()
        for (existingSet in sets) {
            val newSet = existingSet.toMutableList()
            newSet.add(num)
            newSubsets.add(newSet)
        }
        sets.addAll(newSubsets)
    }

    return sets
}

println(subsets(intArrayOf(1, 2, 3, 4, 5)))