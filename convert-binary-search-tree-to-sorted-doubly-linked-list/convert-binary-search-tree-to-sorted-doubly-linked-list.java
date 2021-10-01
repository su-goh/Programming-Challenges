/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        Node[] list = inOrderCreateNode(root);
        if(list[0] != null) list[0].left = list[1];
        if(list[1] != null) list[1].right = list[0];
        
        return list[0];
    }
    
    private Node[] inOrderCreateNode(Node curr) {
        
        if(curr == null) return new Node[]{null, null};
        
        // return rightmost of left subtree
        Node[] left = inOrderCreateNode(curr.left);
        if(left[1] != null) left[1].right = curr;
        curr.left = left[1];
        
        // return leftmost of right subtree
        Node[] right = inOrderCreateNode(curr.right);
        if(right[0] != null) right[0].left = curr;
        curr.right = right[0];
        
        if(left[0] == null) left[0] = curr;
        if(right[1] == null) right[1] = curr;
        
        return new Node[]{left[0], right[1]};
    }
}