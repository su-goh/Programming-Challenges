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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> verticalOrder = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(0, root)); 
        while(!q.isEmpty()) {
            
            int size = q.size();
            HashMap<Integer, ArrayList<Integer>> currLevelVerticalOrder = new HashMap<>();
            
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                min = Math.min(curr.colId, min);
                max = Math.max(curr.colId, max);
                
                currLevelVerticalOrder.putIfAbsent(curr.colId, new ArrayList<>());
                currLevelVerticalOrder.get(curr.colId).add(curr.node.val);

                if(curr.node.left != null) q.add(new Node(curr.colId - 1, curr.node.left));
                if(curr.node.right != null) q.add(new Node(curr.colId + 1, curr.node.right));
            }
            
            for(Integer id : currLevelVerticalOrder.keySet()) {
                ArrayList<Integer> currList = currLevelVerticalOrder.get(id);
                Collections.sort(currList);
                
                verticalOrder.putIfAbsent(id, new ArrayList<>());
                verticalOrder.get(id).addAll(currList);
            }

        }
               
        for(int colId = min; colId <= max; colId++) {
            ArrayList<Integer> currList = verticalOrder.get(colId);
            ret.add(currList);
        }
        
        return ret;
    }
    
    private class Node {
        int colId;
        TreeNode node;
        
        public Node(int colId, TreeNode node) {
            this.colId = colId;
            this.node = node;
        }
    }
}