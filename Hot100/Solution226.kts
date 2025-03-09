import java.util.LinkedList
import java.util.Queue

// 定义 TreeNode 类
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
/**
 * 示例：
 * val ti = TreeNode(5)
 * val v = ti.`val`
 *
 * 二叉树节点的定义：
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
fun invertTree(root: TreeNode?): TreeNode? {
    // 我有个直接的想法: 直接对前几项进行反转, 前1位反转, 第2~3位反转, 第4~7位反转
    if (root == null) {
        return null
    }
    // 递归翻转左子树和右子树
    val left = invertTree(root.left)
    val right = invertTree(root.right)
    // 交换左右子树
    root.left = right
    root.right = left

    return root
}


// 层序遍历打印二叉树（不换行）
fun printTree(root: TreeNode?) {
    if (root == null) return

    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root) // 将根节点加入队列

    while (queue.isNotEmpty()) {
        val node = queue.poll() // 取出队首节点
        print("${node.`val`} ") // 打印当前节点值，并用空格分隔

        // 将左子节点加入队列
        if (node.left != null) {
            queue.offer(node.left)
        }

        // 将右子节点加入队列
        if (node.right != null) {
            queue.offer(node.right)
        }
    }
}

// 测试
//fun main() {
    // 构建二叉树
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(9)

    // 打印原始二叉树
    println("原始二叉树：")
    printTree(root)

    // 翻转二叉树
    val invertedRoot = invertTree(root)

    // 打印翻转后的二叉树
    println("翻转后的二叉树：")
    printTree(invertedRoot)
//}