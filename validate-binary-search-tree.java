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
    public boolean isValidBST(TreeNode root) {
        
        // do in-order if in-order node < previous order node, return false
        List<Integer> arr = new ArrayList<>();
        boolean t = true;
​
        return helper(root, arr, t);
    }
    
    public boolean helper(TreeNode curr, List arr, boolean t) {
        if (!t) return t;
        if (curr == null) return true;
        if (curr.left != null) t = helper(curr.left, arr, t);
        if (!arr.isEmpty() && (int)arr.get(arr.size() - 1) >= curr.val) t = false;
            else arr.add(curr.val);
        if (curr.right != null) t = helper(curr.right, arr, t);
        
        return t;
    }
}
