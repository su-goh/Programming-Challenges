class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    //System.out.println(i + " " + j);
                    numIslands++;
                    DFS(grid,i, j);
                }
            }
        }
        return numIslands;
        
    }
    
    //DFS
    public void DFS(char[][] grid,int i, int j) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(i);
        temp.add(j);
        // mark as visited
        grid[i][j] = '2';
        
        // up
        if(i != 0 && grid[i-1][j] == '1') DFS(grid, i-1, j);
​
        // down
        if(i != grid.length - 1 && grid[i+1][j] == '1') DFS(grid, i+1, j);
​
        // left
        if(j != 0 && grid[i][j - 1] == '1') DFS(grid, i, j - 1);
​
        // right
        if(j != grid[0].length - 1 && grid[i][j + 1] == '1') DFS(grid, i, j + 1);
        
    }
    
    // BFS
    
//     public void BFS(char[][] grid, int i, int j) {
//         Queue<ArrayList> q = new LinkedList<>();
        
//         // put [i,j] into q, mark is visited
//         grid[i][j] = '2';
//         ArrayList<Integer> temp = new ArrayList<>();
//         temp.add(i);
//         temp.add(j);
