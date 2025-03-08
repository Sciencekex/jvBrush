//461. 汉明距离
//简单
//相关标签
//相关企业
//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
//
//给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
//
//
//
//示例 1：
//
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
//示例 2：
//
//输入：x = 3, y = 1
//输出：1
//
//
//提示：
//
//0 <= x, y <= 231 - 1
//
//
//注意：本题与 2220. 转换数字的最少位翻转次数 相同。

fun hammingDistance(x: Int, y: Int): Int {
    var x_bin = Integer.toBinaryString(x)
    var y_bin = Integer.toBinaryString(y)

    val maxLength = maxOf(x_bin.length, y_bin.length)
    val aligndXBin = x_bin.padStart(maxLength, '0')
    val aligndYBin = y_bin.padStart(maxLength, '0')
    var count = 0
    for (i in aligndXBin.indices) {
        if (aligndXBin[i] != aligndYBin[i]) {
            count++
        }
    }
    return count
}

val distan = hammingDistance(42, 10)
println("距离: $distan")