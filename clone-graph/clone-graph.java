/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        map = new HashMap<>();
        
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        dfs(node, newNode);
        
        return newNode;
    }
    
    private void dfs(Node oldNode, Node newNode) {
        for(int i = 0; i < oldNode.neighbors.size(); i++) {
            Node oldChildNode = oldNode.neighbors.get(i);
            Node newChildNode;
            if(!map.containsKey(oldChildNode.val)) {
                newChildNode = new Node(oldChildNode.val);
                map.put(oldChildNode.val, newChildNode);
                dfs(oldChildNode, newChildNode);
            } else {
                newChildNode = map.get(oldChildNode.val);
            }
            newNode.neighbors.add(newChildNode);
        }
        
    }
}