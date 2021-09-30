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
 */
class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        
        return max;
    }
    
    private int helper(TreeNode root) {
        int left = (root.left == null) ? 0 : helper(root.left);
        int right = (root.right == null) ? 0 : helper(root.right);
        
        if(left < 0) left = 0;
        if(right < 0) right = 0;
        max = Math.max(max, left + right + root.val);
        
        return root.val + Math.max(left, right);
    }
}