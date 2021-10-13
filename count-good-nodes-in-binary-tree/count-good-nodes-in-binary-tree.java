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
    int numGoods;
    
    public int goodNodes(TreeNode root) {
        numGoods = 0;
        
        dfs(root, Integer.MIN_VALUE);
        
        return numGoods;
    }
    
    private void dfs(TreeNode root, int largest) {
        if(root.val >= largest) numGoods++;
        largest = Math.max(largest, root.val);

        
        if(root.left != null)
            dfs(root.left, largest);
        
        if(root.right != null)
            dfs(root.right, largest);
    }
}