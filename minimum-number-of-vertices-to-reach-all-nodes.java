class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        // HashSet<Integer> set = new HashSet<>(); surprisingly hashset is slow
        int[] dp = new int[n];
        List<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < edges.size(); i++) {
            // set.add(edges.get(i).get(1));
            dp[edges.get(i).get(1)] = 1;
        }
        
        for(int i = 0; i < n; i++) {
            //if(!set.contains(i)) {
            if(dp[i] == 0) {
                list.add(i);
            }
        }
        
        
         return list;
        
    }
    
​
    
}
​
​
