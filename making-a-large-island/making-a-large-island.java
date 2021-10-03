class Solution {
    int[][] map;
    int[][] grid;
    HashMap<Integer, Integer> sizes;
    
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        this.grid = grid;
        int max = 0;
        map = new int[m][n];
        sizes = new HashMap<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && map[i][j] == 0)
                    countSize(new int[]{i, j});
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // System.out.print(map[i][j] + " ");
                if(grid[i][j] == 0) {
                    int currMax = 1;
                    HashSet<Integer> visitedId = new HashSet<>();
                    
                    if(i - 1 >= 0 && grid[i - 1][j] == 1 && !visitedId.contains(map[i - 1][j])) {
                        visitedId.add(map[i - 1][j]);
                        currMax += sizes.get(map[i - 1][j]);
                    }
                    if(i + 1 < m && grid[i + 1][j] == 1  && !visitedId.contains(map[i + 1][j])) {
                        visitedId.add(map[i + 1][j]);
                        currMax += sizes.get(map[i + 1][j]);
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == 1 && !visitedId.contains(map[i][j - 1])) {
                        visitedId.add(map[i][j - 1]);
                        currMax += sizes.get(map[i][j - 1]);
                    }
                    if(j + 1 < n && grid[i][j + 1] == 1  && !visitedId.contains(map[i][j + 1])) {
                        visitedId.add(map[i][j + 1]);
                        currMax += sizes.get(map[i][j + 1]);
                    }
                    
                    max = Math.max(max, currMax);
                }
            }
            // System.out.println();
        }
        
        return max != 0 ? max : (grid[0][0] == 0 ? 0 : sizes.get(map[0][0]));        
    }
    
    private void countSize(int[] loc) {
        int size = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(loc);
        visited[loc[0]][loc[1]] = true;
        int id = sizes.size();
        
        while(!q.isEmpty()) {
            int[] currLoc = q.poll();
            int i = currLoc[0], j = currLoc[1];
            size++;
            map[i][j] = id;
            
            if(i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                q.add(new int[]{i - 1, j});
            }
            if(i + 1 < visited.length && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                q.add(new int[]{i + 1, j});
            }
            if(j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                q.add(new int[]{i, j - 1});
            }
            if(j + 1 < visited[0].length && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                q.add(new int[]{i, j + 1});
            }
        }
        
        sizes.put(id, size);
        
//         visited = new boolean[grid.length][grid[0].length];
//         q.add(loc);
//         while(!q.isEmpty()) {
//             int[] currLoc = q.poll();
//             int i = currLoc[0], j = currLoc[1];
//             map[i][j] = size;
            
//             if(i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
//                 visited[i - 1][j] = true;
//                 q.add(new int[]{i - 1, j});
//             }
//             if(i + 1 < visited.length && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
//                 visited[i + 1][j] = true;
//                 q.add(new int[]{i + 1, j});
//             }
//             if(j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
//                 visited[i][j - 1] = true;
//                 q.add(new int[]{i, j - 1});
//             }
//             if(j + 1 < visited[0].length && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
//                 visited[i][j + 1] = true;
//                 q.add(new int[]{i, j + 1});
//             }
//         }
        
    }
}