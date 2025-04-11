package Daily1t

fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int {
    // 创建一个嵌套的 Map 结构：Map<Int, MutableMap<Int, Int>>
    val groupMap = mutableMapOf<Int, MutableMap<Int, Int>>()

    // 遍历 pick 数组，填充 groupMap
    for (p in pick) {
        val key = p[0]
        val subKey = p[1]

        // 如果外层 Map 中不存在 key，则初始化一个内层 Map
        if (!groupMap.containsKey(key)) {
            groupMap[key] = mutableMapOf()
        }

        // 更新内层 Map 的计数
        groupMap[key]!![subKey] = groupMap[key]!!.getOrDefault(subKey, 0) + 1
    }

    // 统计满足条件的组数
    var count = 0
    for ((key, subMap) in groupMap) {
        // 检查内层 Map 中是否有值大于 key
        for (value in subMap.values) {
            if (value > key) {
                count++
                break
            }
        }
    }

    return count
}