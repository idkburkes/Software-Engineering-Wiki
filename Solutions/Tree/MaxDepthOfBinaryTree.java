package Solutions.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * 
 * Solution is very simple. Just recursively process the depth of left
 * and right subtrees, adding 1 at each level. If left and right pointer is
 * null then return 0. Return the max depth between left and right subtrees.
 * 
 */
public class MaxDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        //Leaf node
        if(root == null) {
            return 0;
        }
                 
        int maxDepthLeft = 1 + maxDepth(root.left); //process left
        int maxDepthRight = 1 + maxDepth(root.right); //process right
        return Math.max(maxDepthLeft, maxDepthRight); //return deepest subtree
    }
    
}
