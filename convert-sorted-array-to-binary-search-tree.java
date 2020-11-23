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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int left = 0, right = nums.length - 1, mid = left + (right - left) / 2;
        return (nums.length == 0) ? null : sortedArrayHelper(nums, left, right);
    }
    
    public TreeNode sortedArrayHelper(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        
        // base case
        if(Math.abs(right - left) <= 1) {
            if(right != mid) curr.right = new TreeNode(nums[right]);
            return curr;
        }
        
        // recursive case
        curr.left = sortedArrayHelper(nums, left, mid-1);
        curr.right = sortedArrayHelper(nums, mid+1, right);
​
        return curr;
    }
}
