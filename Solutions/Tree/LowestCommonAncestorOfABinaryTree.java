package Solutions.Tree;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //Solution pattern is to recursively check if root node has both nodes
        //in its subtrees
        
        //Base cases. If we reach bottom of tree without finding value then return null
        if(root == null || root.val == p.val || root.val == q.val ) return root;
        
        //Check left
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        //Check right
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        
        //If both subtrees contain desired values then this is the LCA
        if(left != null && right != null) return root;
        
        //If only one contains value then return either left or right
        if(left != null) {
            return left;
        } else {
            return right;
        }
        
        
    }
}
