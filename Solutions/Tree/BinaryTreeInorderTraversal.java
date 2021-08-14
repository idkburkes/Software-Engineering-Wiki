package Solutions.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * This is the base solution for any other problems that require
 * Binary Tree inorder traversal
 * 
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> inorder = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()) {
            
            while(root != null) {
                stack.push(root);
                root = root.left;
            }   
            
            root = stack.pop();
            inorder.add(root.val);
            prev = root;
            root = root.right;
            
        }
         return inorder;
    }
}
