package Solutions.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from
 * left to right, level by level).
 * 
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this
 * node's descendants. The tree tree could also be considered as a subtree of itself.
 * 
 *  * Definition for a binary tree node.
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
 *  The solution pattern for this was Breadth-First Search.
 *  An important method in my solution was .peek(), where I was able to retrieve 
 *  a reference to the front of the Queue without removing it. This allowed me to post-order
 *  process the tree and add the left and right child nodes to the queue before I removed the current node.
 * 
 * 
 */
public class BinaryTreeLevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        //Edge cases
        if(root == null) {
            return levelOrder;
        }

        //Use queue to store nodes
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);        
        
        while(!Q.isEmpty()) {
        List<Integer> currentLevel = new ArrayList<>();
        //Use current size of the queue to know how many values we should poll for this level
        int levelNodeCount = Q.size();
        for(int i = 0; i < levelNodeCount; i++) {
        //Post-order processing. Add left and right children to queue then add current node to list 
        if(Q.peek().left != null) { Q.offer(Q.peek().left); }
        if(Q.peek().right != null) { Q.offer(Q.peek().right); }
        currentLevel.add(Q.poll().val);
            }
        levelOrder.add(currentLevel); //Add current level to level-order array
        }

        return levelOrder;
    }
    


}
