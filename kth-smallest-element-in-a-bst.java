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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode curr = root;
        int count = 0;
        
        while(!s.isEmpty()) {
            if(curr == null) {
                TreeNode now = s.pop();
                count++;
                if(count == k) return now.val;
                curr = now.right;
            } else curr = curr.left;
            if(curr != null) s.push(curr);
        }
    
        return 1;
    }
​
}
