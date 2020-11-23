/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        int left = 0;
        int right = 0;
        int max = 0;
        
        if(root == null) {
            return 0;
        }
        
        // base case, leaf node
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        // recursive
        left = maxDepth(root.left) + 1;
        right = maxDepth(root.right) + 1;
        
        return (left > right) ? left: right;
        
    }
}
