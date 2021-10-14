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

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root, 0).node;
    }
    
    private NodeWithDepth helper(TreeNode root, int depth) {
        NodeWithDepth left = new NodeWithDepth(depth, root); 
        NodeWithDepth right = new NodeWithDepth(depth, root);
        
        if(root.left != null) left = helper(root.left, depth + 1);
        if(root.right != null) right = helper(root.right, depth + 1);

        if(left.depth == right.depth) return new NodeWithDepth(left.depth, root);
        else if(left.depth < right.depth) return right;
        else return left;
    }
    
    class NodeWithDepth {
        int depth;
        TreeNode node;
        
        public NodeWithDepth(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
}