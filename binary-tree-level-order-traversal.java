import java.util.Queue;
import java.util.LinkedList;
​
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
    public List<List<Integer>> levelOrder(TreeNode root) {
​
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        List<List<Integer>> li = new ArrayList();
        List<Integer> temp;
        
        if (root == null) return li;
        
        // add root to queue
        que.add(root);
        
        // if queue is not empty, visit node
        // if node visited has children, add to queue
        // remove node
        while(!que.isEmpty()) {
            temp = new ArrayList();
            int level = que.size();
​
            for(int i = 0; i < level; i++){
                if(que.peek().left != null) que.add(que.peek().left);            
                if(que.peek().right != null) que.add(que.peek().right);
                temp.add(que.poll().val);
            }
            
            li.add(temp);
