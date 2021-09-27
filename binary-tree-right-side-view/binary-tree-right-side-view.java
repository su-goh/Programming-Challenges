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
    List<Integer> ret;
    public List<Integer> rightSideView(TreeNode root) {
        ret = new ArrayList<>();
        if(root == null) return ret;
        
        helper(root, 0, -1);
        
        return ret;
    }
    
    private int helper(TreeNode root, int level, int maxLevel) {   
        if(maxLevel < level) {
            ret.add(root.val);
            maxLevel = level;
        }
        
        if(root.right != null) maxLevel = helper(root.right, level + 1, maxLevel);
        // System.out.println(root.val + " " + maxLevel);
        if(root.left != null) maxLevel = helper(root.left, level + 1, maxLevel);
        
        return maxLevel;
    }
}