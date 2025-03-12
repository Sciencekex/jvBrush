//118. 杨辉三角
//已解答
//简单
//相关标签
//相关企业
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
//在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
//示例 1:
//
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//示例 2:
//
//输入: numRows = 1
//输出: [[1]]
//
//
//提示:
//
//1 <= numRows <= 30

fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (numRows == 0) return result
    result.add(listOf(1))
    for (row in 1 until numRows) {
        val previousRow = result[row - 1]
        val currentRow = mutableListOf<Int>()
        currentRow.add(1)
        for (j in 1 until row) {
            currentRow.add(previousRow[j - 1] + previousRow[j])
        }
        currentRow.add(1)
        result.add(currentRow)
    }
    return result
}

println(generate(5))

//简单题我重拳出击，中等题我努力思考，困难题我复制粘贴
//简单题我重拳出击（暴力求解——>努力思考——>超时——复制粘贴），中等题我努力思考（暴力求解——>复制粘贴），困难题我复制粘贴。
//总结： 复制粘贴