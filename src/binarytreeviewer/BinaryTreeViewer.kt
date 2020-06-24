package binarytreeviewer

import kotlin.math.ceil
import kotlin.math.pow

/**
 * Support print BinaryTree like that:
           5
        *     *
     6           8
    *  *        *  *
  1     8     7     9

 * @author lamhoangx
 */
class BinaryTreeViewer(private val tree: TreeNode) {
    private val deepTree = getDeep(tree)
    private val maxSizeLeaf = 2 * deepTree
    private val rangeLeaf = maxSizeLeaf * 2 //Cuz each a node have a line connect to parent node

    fun print() {
        print(0, listOf(tree))
    }

    private fun print(deep: Int, trees: List<TreeNode?>?) {
        if(trees == null || trees.isEmpty()) return
        printTreeValue(deep, trees)
        val listTree = ArrayList<TreeNode?>()
        for(tree in trees) {
            listTree.add(tree?.left)
            listTree.add(tree?.right)
        }
        println()
        printConnectLine(deep, trees)
        println()
        var valid = false
        for(tree in listTree) {
            if(tree != null) {
                valid = true
                break
            }
        }
        if(!valid) return
        print(deep + 1, listTree)
    }
    private fun printTreeValue(deep: Int, trees: List<TreeNode?>) {
        val numNodeAtDeep = (2.0.pow(deep.toDouble())).toInt()
        val paddingOffset = rangeLeaf / (numNodeAtDeep)
        for(tree in trees) {
            printPadding(paddingOffset - 1) // 1 is a slot to fill value's node
            if (tree != null) {
                print(tree.value)
            } else {
                printPadding(1) // fill to hold empty value
            }
            printPadding(paddingOffset)
        }
    }
    private fun printConnectLine(deep: Int, trees: List<TreeNode?>) {
        val numNodeAtDeep = (2.0.pow(deep.toDouble())).toInt()
        val paddingOffset = rangeLeaf / numNodeAtDeep
        val paddingLineOffset = (paddingOffset / 4f) // connector live between parent and child, so break up to 4 to get offset

        // sub 1 cuz this is a slot to fill value's node
        for(tree in trees) {
            if (tree != null) {
                printPadding(ceil(paddingLineOffset * 3.0).toInt() - 1)
                //print left node
                if(tree.left != null) {
                    print("*")
                } else {
                    printPadding(1)
                }
                printPadding(ceil(paddingLineOffset).toInt())

                //print right node
                printPadding(ceil(paddingLineOffset).toInt() - 1)
                if(tree.right != null) {
                    print("*")
                } else {
                    printPadding(1)
                }
                printPadding(ceil(paddingLineOffset * 3.0).toInt())
            } else {
                printPadding(paddingOffset * 2) //fill padding for left and right
            }
        }
    }
    companion object {
        private const val PADDING_SPACE = " "
        fun printPadding(num: Int) {
            for(i in 1..num) {
                print(PADDING_SPACE)
            }
        }

        fun getDeep(node: TreeNode?): Int {
            node?.let {
                return getDeep(node.left).coerceAtLeast(getDeep(node.right)) + 1
            }
            return 0
        }

        fun isLeaf(tree: TreeNode?) : Boolean {
            tree?.let {
                tree.left?.let {
                    tree.right?.let {
                        return true
                    }
                }
            }
            return false
        }

        fun print(msg: String){
            kotlin.io.print(msg)
        }
        fun println(msg: String){
            kotlin.io.println(msg)
        }
    }
}

