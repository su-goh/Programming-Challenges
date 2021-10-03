class Solution {
    int[][] grid;
    int[][] visitedBy;
    
    public int shortestDistance(int[][] grid) {
        this.grid = grid;
        int[][] map = new int[grid.length][grid[0].length];
        visitedBy = new int[grid.length][grid[0].length];
        int min = Integer.MAX_VALUE;
        int numBlocks = 0;
        
        // pre process
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] > 0) {
                    map[i][j] = Integer.MAX_VALUE;
                }
                if(grid[i][j] == 1) numBlocks++;
            }
        }
        
        // numBlocks = grid.length * grid[0].length - numBlocks;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 && !processMap(i, j, map, numBlocks)) return -1;
            }
        }
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(visitedBy[i][j] == numBlocks) min = Math.min(min, map[i][j]);
                // System.out.print(map[i][j] + " ");
            }
            // System.out.println();
        }
        
        return min == Integer.MAX_VALUE || min == 0 ? -1 : min;
    }
    
    private boolean processMap(int i, int j, int[][] map, int numBlocks) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, 0});
        boolean[][] visited = new boolean[map.length][map[0].length]; 
        int numVisited = 0;
        
        while(!q.isEmpty()) {
            int[] currLoc = q.poll();
            int currI = currLoc[0];
            int currJ = currLoc[1];
            int dist = currLoc[2];
            
            if(grid[currI][currJ] == 0) {
                map[currI][currJ] += dist;
                visitedBy[currI][currJ] += 1;
            }

            if(currI - 1 >= 0) {
                if(!visited[currI - 1][currJ] && grid[currI - 1][currJ] == 0) {
                    visited[currI - 1][currJ] = true;
                    q.add(new int[]{currI - 1, currJ, dist + 1});
                } else if (grid[currI - 1][currJ] == 1 && !visited[currI - 1][currJ]) {
                    numVisited++;
                    visited[currI - 1][currJ] = true;
                }
            }
            if(currI + 1 < map.length) {
                if(!visited[currI + 1][currJ] && grid[currI + 1][currJ] == 0) {
                    visited[currI + 1][currJ] = true;
                    q.add(new int[]{currI + 1, currJ, dist + 1});
                } else if(grid[currI + 1][currJ] == 1 && !visited[currI + 1][currJ]) {
                    numVisited++;
                    visited[currI + 1][currJ] = true;
                }
            }
            if(currJ - 1 >= 0) {
                if(!visited[currI][currJ - 1] && grid[currI][currJ - 1] == 0) {
                    visited[currI][currJ - 1] = true;
                    q.add(new int[]{currI, currJ - 1, dist + 1});
                } else if(grid[currI][currJ - 1] == 1 && !visited[currI][currJ - 1]) {
                    numVisited++;
                    visited[currI][currJ - 1] = true;
                }
                
            }
            if(currJ + 1 < map[currI].length) {
                if(!visited[currI][currJ + 1] && grid[currI][currJ + 1] == 0) {
                    visited[currI][currJ + 1] = true;
                    q.add(new int[]{currI, currJ + 1, dist + 1});
                } else if(grid[currI][currJ + 1] == 1 && !visited[currI][currJ + 1]) {
                    numVisited++;
                    visited[currI][currJ + 1] = true;
                }
            }
            
        }
        
        // System.out.println(numVisited + " " + numBlocks);
        return (numVisited == numBlocks);
    }
}