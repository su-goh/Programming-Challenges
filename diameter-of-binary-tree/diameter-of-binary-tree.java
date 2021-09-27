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
    int maxLen;
    public int diameterOfBinaryTree(TreeNode root) {
        maxLen = 0;
        
        findMaxLen(root);
        
        return maxLen;
    }
    
    private int findMaxLen(TreeNode root) {        
        int lenLeft = (root.left == null) ? 0 : findMaxLen(root.left) + 1;
        int lenRight = (root.right == null) ? 0 : findMaxLen(root.right) + 1;
        
        maxLen = Math.max(maxLen, lenLeft + lenRight);
                
        return Math.max(lenLeft, lenRight);
    }
}