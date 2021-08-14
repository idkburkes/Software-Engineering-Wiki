package Solutions.Tree;

import java.util.Stack;

/**
 * Inorder Traversal was used to find kth smallest in a BST
 * 
 * 
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()) {
            
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(--k == 0) return root.val;
            prev = root;
            root = root.right;  
        }
        return 0;    
    }
}
