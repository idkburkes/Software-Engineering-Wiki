package Solutions.Tree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean nodeMatches = true;
        
        //Handle leaf node cases
        if(p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }
        
        //Process current node
        if(p.val != q.val) {
            nodeMatches = false;
        }
        
        //Process left
        boolean leftMatches = isSameTree(p.left, q.left);
        //Process right
        boolean rightMatches = isSameTree(p.right, q.right);
        
        return (nodeMatches && leftMatches && rightMatches);
        
    }
}
