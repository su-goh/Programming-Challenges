class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        //Goal: find source of DAG = sink of reverse DAG
        // using DFS to find sink
        
//         Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < edges.size(); i++) {
            set.add(edges.get(i).get(1));
        }
        
        for(int i = 0; i < n; i++) {
            if(!set.contains(i)) {
                list.add(i);
            }
        }
        
        
         return list;
        
    }
    
}
