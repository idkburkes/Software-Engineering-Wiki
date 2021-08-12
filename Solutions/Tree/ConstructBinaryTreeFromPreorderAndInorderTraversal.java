package Solutions.Tree;

import java.util.Arrays;


/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal
 * of a binary tree and inorder is the inorder traversal of the same tree, construct and return
 * the binary tree.
 * 
 * This was kind of complicated. I had to note that the first index in preorder was
 * guaranteed to be the root node of the tree currently being built. Then you need to know
 * that the location of this node in inorder separates the left subtree to the left of the 
 * inorder array, and the right subtree is all the values to the right of root in inorder.
 * 
 * I used this information to recursively build the left and right subtrees. I don't think
 * the time complexity of this is very great because I'm using a linear search to find the index
 * of the root node in the inorder array but I can't think of a better search strategy at the moment
 * since it is not sorted
 * 
 * 
 * 
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base case
        if(preorder.length == 1) {
            return new TreeNode(preorder[0]);
        } else if(preorder == null || preorder.length == 0){
            return null;
        }
        
        //First index in preorder is the root of this subtree
        TreeNode root = new TreeNode(preorder[0]);
        
        //Index of root in inorder array is the mid point
        int mid = 0;
        for(int i = 0; i < inorder.length; i++){
            if(root.val == inorder[i]){
                mid = i;
                break;
            }
        }
        
        //Build left subtree from index 1 to mid in preorder 
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        //Build right subtree from mid + 1 to end in preorder
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));

        return root;
        
    }

}