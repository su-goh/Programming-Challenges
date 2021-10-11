class Solution {
    HashMap<String, PriorityQueue<String>> adjList;
    List<String> it;
    public List<String> findItinerary(List<List<String>> tickets) {
        adjList = new HashMap<>();
        it = new ArrayList<>();
        
        for(List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            adjList.putIfAbsent(src, new PriorityQueue<>((a, b) -> a.compareTo(b)));
            adjList.get(src).add(dest);
        }
        
        helper("JFK");
        
        return it;
    }
    
    private void helper(String currSpot) {
        while (adjList.get(currSpot) != null && adjList.get(currSpot).size() > 0) {
            String nextSpot = adjList.get(currSpot).poll();
            helper(nextSpot);
        }
        it.add(0, currSpot);
    }
}