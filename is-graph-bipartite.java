class Solution {
    public boolean isBipartite(int[][] graph) {
        // 0 represents unvisted, 1 represents color 1, 2 represents color 2
        int[] color = new int[graph.length];
        
        // for all undiscovered graph, call dfs
        for(int i = 0; i < graph.length; i++) {
            if(color[i] == 0) {
                color[i] = 1;
                // if dfs return false, return false
                if(!bfs(graph, color, i)) return false;
            }
        }
        
        return true;
    }
    
//     public boolean dfs(int[][] graph, int[] color, int vertex) {
//         // for all unvisted adjacent vertex of v, dfs(v)
//         for(int neighbor: graph[vertex]) {
//             if(color[neighbor] == 0) {
//                 if(color[vertex] == 1) color[neighbor] = 2;
//                 else if(color[vertex]  == 2) color[neighbor] = 1;
                
                
//                 if (!dfs(graph, color, neighbor)) return false;
//             } else if(color[neighbor] == color[vertex]) return false;
//         }
        
//         return true;
//     }
    
    public boolean bfs(int[][] graph, int[] color, int vertex) {
        color[vertex] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        
        while(q.size() != 0) {
            int u = q.poll();
            for(int v: graph[u]) {
                if(color[v] == 0) {
