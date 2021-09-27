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
    ArrayList<TreeNode> sorted;
    public TreeNode balanceBST(TreeNode root) {
        sorted = new ArrayList<>();
        convertToArray(root);
        return convertToBST(0, sorted.size() - 1);
    }
    
    private void convertToArray(TreeNode root) {
        if(root.left != null) convertToArray(root.left);
        sorted.add(root);
        if(root.right != null) convertToArray(root.right);
        root.left = null;
        root.right = null;
    }
    
    private TreeNode convertToBST(int start, int end) {
        int mid = start + (end - start)/2;
        
        TreeNode newRoot = sorted.get(mid);
        if(mid - 1 >= start) newRoot.left = convertToBST(start, mid - 1);
        if(mid + 1 <= end) newRoot.right = convertToBST(mid + 1, end);
        
        return newRoot;
    }
}