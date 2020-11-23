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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        
        HashMap<TreeNode, Integer> choose = new HashMap<>();
        HashMap<TreeNode, Integer> skip = new HashMap<>();
        
        postOrder(root, choose, skip);
        
        return Math.max(choose.get(root), skip.get(root));
    }
    
    public void postOrder(TreeNode curr, HashMap choose, HashMap skip) {
        int chooseChild = 0, skipChild = 0;
        
        if(curr.left != null) {
            postOrder(curr.left, choose, skip);
            chooseChild += Math.max((Integer)choose.get(curr.left),             (Integer)skip.get(curr.left));
            skipChild += (Integer)skip.get(curr.left);
        }
        
        if(curr.right != null){
            postOrder(curr.right, choose, skip);
            chooseChild += Math.max((Integer)choose.get(curr.right),             (Integer)skip.get(curr.right));
            skipChild += (Integer)skip.get(curr.right);
        }
​
        
        
        choose.put(curr, curr.val + skipChild);
        skip.put(curr, chooseChild);
    }
}
