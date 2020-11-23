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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if (root == null) return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<>();
        
        // L V R
        // if(root.left != null) inorderTraversal(root.left);
        // list.add(root.val);
        // if(root.right != null) inorderTraversal(root.right);
        
        return helper(root, list);
        
    }
    
    public List<Integer> helper(TreeNode curr, List list) {
        if(curr.left != null) helper(curr.left, list);
        list.add(curr.val);
        if(curr.right != null) helper(curr.right, list);
        return list;
    }
}
