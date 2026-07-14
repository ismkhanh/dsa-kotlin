/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return hasPath(0, root, targetSum)
    }

    private fun hasPath(curSum: Int, node: TreeNode?, targetSum: Int): Boolean {
        if (node == null) return false
        if (isLeaf(node)) return node.`val` + curSum == targetSum
        

        val newSum = curSum + node.`val`
        return hasPath(newSum, node.left, targetSum) || hasPath(newSum, node.right, targetSum)
    }

    private fun isLeaf(node: TreeNode) = (node.left == null && node.right == null)
}
