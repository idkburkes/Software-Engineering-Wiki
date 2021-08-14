package Solutions.Tree;


/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of
 * root with the same structure and node values of subRoot and false otherwise.
 * 
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this
 * 
 */
public class SubtreeOfAnotherTree {
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //If both nodes are null they're the same
        if(root == null && subRoot == null) {
            return true;
        //If only one node is null they're not the same
        } else if (root == null || subRoot == null) {
            return false;
        }
    
    //Process current node
    if(isSame(root, subRoot)){
        return true;
    }
    
   //If current node is not subtree, process left & right child nodes
    return (isSubtree(root.left, subRoot) 
            || isSubtree(root.right, subRoot));
}

public boolean isSame(TreeNode node1, TreeNode node2) {
    //If both nodes are null they're the same
    if(node1 == null && node2 == null) {
        return true; 
    //If only one node is null they're not the same
    } else if (node1 == null || node2 == null) {
        return false;
    }
    
    //Check if current node values and Left/Right subtrees are the same
    boolean sameValue = (node1.val == node2.val);
    boolean sameLeftSubtree = isSame(node1.left, node2.left);
    boolean sameRightSubtree = isSame(node1.right, node2.right);
    
    //If all three conditions hold then trees are the same
    return (sameValue && sameLeftSubtree && sameRightSubtree);
}


}
