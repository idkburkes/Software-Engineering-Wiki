package Solutions.Tree;

import java.util.Stack;

/**
 * Used Inorder Traversal
 * 
 * 
 */
public class ValidateBinarySearchTree {
    


    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        } 
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;


        while(!stack.isEmpty() || root != null) {
                while(root != null) { //Traverse left until end of tree
                    stack.push(root); //Add every left child to stack
                    root = root.left;
                }
                root = stack.pop();
                //Root should always be bigger than prev
                if(prev != null && root.val <= prev.val) return false;
                prev = root;
                root = root.right; //Execute iteratively on right child to make inorder 

        }  
        return true;
    }
}
