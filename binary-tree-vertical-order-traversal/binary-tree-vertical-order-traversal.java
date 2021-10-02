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
    List<List<Integer>> temp;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        temp = new ArrayList<>();
        for(int i = 0; i < 200; i++) temp.add(null);
        List<List<Integer>> ret = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        if(root == null) return ret;
        
        q.add(new Node(100, root));
        while(!q.isEmpty()) {
            Node currNode = q.poll();
            if(temp.get(currNode.idx) == null) temp.set(currNode.idx, new ArrayList<>());
            temp.get(currNode.idx).add(currNode.root.val);
            
            if(currNode.root.left != null) q.add(new Node(currNode.idx - 1, currNode.root.left));
            if(currNode.root.right != null) q.add(new Node(currNode.idx + 1, currNode.root.right));
        }
        
        for(int i = 0; i < temp.size(); i++)
            if(temp.get(i) != null) ret.add(temp.get(i));
        
        return ret;
    }
    
    private class Node {
        int idx;
        TreeNode root;
        
        public Node(int idx, TreeNode root) {
            this.idx = idx;
            this.root = root;
        }
    }
    
//     private void helper(TreeNode root, int idx) {
//         System.out.println(root.val);
//         if(temp.get(idx) == null) temp.set(idx, new ArrayList<>());
//         temp.get(idx).add(root.val);

//         if(root.left != null) helper(root.left, idx - 1);
//         if(root.right != null) helper(root.right, idx + 1);
//     }
}