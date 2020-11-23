class Solution {
    public int uniquePaths(int m, int n) {
        
        // recursively
        /**
        if(m == 1 || n == 1) return 1;
        
        // down + right
        return uniquePaths(m, n-1) + uniquePaths(m-1, n);
        **/
        
        // iteratively
        int[][] board = new int[m][n];
        
        for(int i = 0; i < n; i++) board[m-1][i] = 1;
        for(int i = 0; i < m; i++) board[i][n-1] = 1;
        
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >=0; j--) {
                board[i][j] = board[i][j+1] + board[i+1][j];
            }
        }
        
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
​
        
        return board[0][0];
    }
}
