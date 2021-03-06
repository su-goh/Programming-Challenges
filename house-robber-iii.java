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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        
        int[] dp = postOrder(root);
        
        return Math.max(dp[0], dp[1]);
        
        // naiive because you dont need to store everything! Just two everytime.
//         HashMap<TreeNode, Integer> choose = new HashMap<>();
//         HashMap<TreeNode, Integer> skip = new HashMap<>();
        
//         postOrder(root, choose, skip);
        
//         return Math.max(choose.get(root), skip.get(root));
    }
    
//     public void postOrder(TreeNode curr, HashMap choose, HashMap skip) {
//         int chooseChild = 0, skipChild = 0;
        
//         if(curr.left != null) {
//             postOrder(curr.left, choose, skip);
//             chooseChild += Math.max((Integer)choose.get(curr.left),(Integer)skip.get(curr.left));
//             skipChild += (Integer)skip.get(curr.left);
//         }
        
//         if(curr.right != null){
//             postOrder(curr.right, choose, skip);
//             chooseChild += Math.max((Integer)choose.get(curr.right),(Integer)skip.get(curr.right));
//             skipChild += (Integer)skip.get(curr.right);
//         }       
        
//         choose.put(curr, curr.val + skipChild);
//         skip.put(curr, chooseChild);
//     }
    
    public int[] postOrder(TreeNode curr) {
        int[] dp = new int[2]; //1 represents maxVal if choose curr, 2 maxVal if skip curr
        int[] dpLeft;
        int[] dpRight;
        int chooseChild = 0;
        int skipChild = 0;
        
        if(curr.left != null) {
            dpLeft = postOrder(curr.left);
            chooseChild += Math.max(dpLeft[0], dpLeft[1]);
            skipChild += dpLeft[1];
        }
        
        if(curr.right != null) {
            dpRight = postOrder(curr.right);
            chooseChild += Math.max(dpRight[0], dpRight[1]);
            skipChild += dpRight[1];
        }
        
        dp[0] = curr.val + skipChild;
        dp[1] = chooseChild;
        return dp;
    }
}
