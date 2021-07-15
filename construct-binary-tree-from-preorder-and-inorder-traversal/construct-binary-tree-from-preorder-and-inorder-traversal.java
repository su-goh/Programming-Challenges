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
    HashMap<Integer, Integer> map;
    int j = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        TreeNode curr = new TreeNode(preorder[j]);
        int index = map.get(preorder[j]);
        if(j+1 < preorder.length && map.get(preorder[j+1]) < index && (index - 1) - start >= 0) {
            j++;
            curr.left = helper(preorder, inorder, start, index - 1);
        }
        if(j+1 < preorder.length && map.get(preorder[j+1]) > index && end - (index + 1) >= 0) {
            j++;
            curr.right = helper(preorder, inorder, index+1, end);
        }
        
        return curr;
    }
}