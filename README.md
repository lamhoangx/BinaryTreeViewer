# BinaryTreeViewer
Support print BinaryTree like that:
```
           5
        *     *
     6           8
    *  *        *  *
  1     8     7     9
```
####Sample
```kotlin Main.kt
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
```
#####Output
```
           4                
       *       *            
   2               7        
     *           *   *      
       3       6       9    
      *       *         *   
     1       0           10  
```
#
Happy coding!
