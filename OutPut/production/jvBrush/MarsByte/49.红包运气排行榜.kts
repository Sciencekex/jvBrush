// 问题描述
// 小C参与了一场抢红包的游戏，现在他想要对所有参与抢红包的人进行一次运气排名。排名规则如下：抢到的金额越多，排名越靠前；如果两个人抢到的金额相同，则按照他们抢红包的顺序进行排名。比如，如果小C和小U抢到的金额相同，但小C比小U先抢，则小C排在小U前面。

// 测试样例
// 样例1：

// 输入：n = 4 ,s = ["a", "b", "c", "d"] ,x = [1, 2, 2, 1]
// 输出：['b', 'c', 'a', 'd']

// 样例2：

// 输入：n = 3 ,s = ["x", "y", "z"] ,x = [100, 200, 200]
// 输出：['y', 'z', 'x']

// 样例3：

// 输入：n = 5 ,s = ["m", "n", "o", "p", "q"] ,x = [50, 50, 30, 30, 20]
// 输出：['m', 'n', 'o', 'p', 'q']

fun solution(n: Int, s: List<String>, x: List<Int>): List<String> {
    val data = mutableMapOf<String, Pair<Int, Int>>()
    for (i in 0 until n) {
        val char = s[i]
        val value = x[i]
        data[char] = data[char]?.let { Pair(it.first, it.second + value) } ?: Pair(i + 1, value)
    }
    
    val sortedItems = data.entries.sortedWith(compareBy(
        { -it.value.second },  // 金额降序
        { it.value.first }     // 原始顺序升序
    ))
    
    return sortedItems.map { it.key }
}

// 测试用例保持相同逻辑
fun main() {
    println(solution(4, listOf("a","b","c","d"), listOf(1,2,2,1)) == listOf("b","c","a","d"))
    println(solution(3, listOf("x","y","z"), listOf(100,200,200)) == listOf("y","z","x"))
}

//     ["aa","aaaaaaa","aaaa","aaaa","aaaa","aaaaaaaaaa","aaaaaaaaa","aaaa","aaaaaaaaaa","aaaaaaaaa","aaaaa","aaaa"]
// [17,14,11,2,8,16,14,17,10,6,5,12]

// data = {}
//     for i in range(n):
//         char=s[i]
//         value=x[i]
//         data[char]=[i+1,value]
//     print(data)

// 在这个阶段优化一下, 把同名的红包金额合并在一起