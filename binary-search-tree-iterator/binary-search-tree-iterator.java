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
class BSTIterator {
    ArrayList<Integer> order;
    int pointer;
    
    public BSTIterator(TreeNode root) {
        order = new ArrayList<Integer>(); 
        pointer = - 1;
        
        convertToArray(root);
        // for(int i = 0; i < order.size(); i++) System.out.println(order.get(i));
    }
    
    private void convertToArray(TreeNode root) {
        if(root.left != null) convertToArray(root.left);
        order.add(root.val);
        if(root.right != null) convertToArray(root.right);
    }
    
    public int next() {
        return order.get(++pointer);
    }
    
    public boolean hasNext() {
        if(pointer + 1 < order.size()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */