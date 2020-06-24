import binarytreeviewer.BinaryTreeViewer
import binarytreeviewer.TreeNode
import com.sun.source.tree.Tree

fun main() {
    val tree = TreeNode(4)
    tree.left = TreeNode(2).apply {

        right = TreeNode(3).apply {
            left = TreeNode(1)
        }
    }
    tree.right = TreeNode(7).apply {
        left = TreeNode(6).apply {
            left = TreeNode(0)
        }
        right = TreeNode(9).apply {
            right = TreeNode(10)
        }
    }
    BinaryTreeViewer(tree).print()
}