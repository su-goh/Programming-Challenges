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
    List<Integer> left;
    List<Integer> right;
    List<Integer> leaves;
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        left = new ArrayList<>();
        leaves = new ArrayList<>();
        right = new ArrayList<>();
        
        left.add(root.val);
        if(root.left != null) preorder(root.left, 0); // left boundary
        if(root.right != null) preorder(root.right, 1); // right boundary
        
        left.addAll(leaves);
        left.addAll(right);
        
        return left;
    }
    
    private void preorder(TreeNode root, int type) {
        if (root.left == null && root.right == null) leaves.add(root.val);
        else if(type == 0) left.add(root.val);
        else if(type == 1) right.add(0, root.val);
        
        if(root.left != null) {
            int leftFlag;
            if(type == 0) leftFlag = 0;
            else if(type == 1 && root.right == null) leftFlag = 1;
            else leftFlag = 3;
            
            preorder(root.left, leftFlag);
        }
        
        if(root.right != null) {
            int rightFlag;
            if(type == 1) rightFlag = 1;
            else if(type == 0 && root.left == null) rightFlag = 0;
            else rightFlag = 3;
            
            preorder(root.right, rightFlag);
        }
    }
}