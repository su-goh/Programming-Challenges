/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    HashSet<Node> pPath;
    HashSet<Node> qPath;
    
    public Node lowestCommonAncestor(Node p, Node q) {
        pPath = new HashSet<>();
        qPath = new HashSet<>();
        Node lca;
        
        while(p != null) {
            pPath.add(p);
            p = p.parent;
        }
        
        while(q != null) {
            qPath.add(q);
            if(pPath.contains(q)) return q;
            q = q.parent;
        }
        
        return null;
    }
}