class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[][] board = new int[n][n];
        int numMoves = moves.length;
        
        // build board
        boolean turns = true;
        for(int i = 0; i < numMoves; i++) {
            board[moves[i][0]][moves[i][1]] = turns ? 1 : 2;
            turns = !turns;
        }
        
        // check horizontal
        for(int i = 0; i < n; i++) {
            int currToken = board[i][0];
            for(int j = 1; j < n; j++) {
                if(board[i][j] != currToken) break;
                if(j == n - 1) {
                    if(currToken == 1) return "A";
                    else if(currToken == 2) return "B";
                }
            }
        }
        
        // check vertical
        for(int i = 0; i < n; i++) {
            int currToken = board[0][i];
            for(int j = 1; j < n; j++) {
                if(board[j][i] != currToken) break;
                if(j == n - 1) {
                    if(currToken == 1) return "A";
                    else if(currToken == 2) return "B";
                }
            }
        }
        
        // check "\" and "/"
        int diag1 = board[0][0];
        int diag2 = board[0][n - 1];
        for(int i = 1; i < n; i++) {
            if(board[i][i] != diag1) diag1 = -1;
            if(board[i][n - i - 1] != diag2) diag2 = -1;
        }
        
        if(diag1 == 1) return "A";
        else if(diag1 == 2) return "B";
        if(diag2 == 1) return "A";
        else if (diag2 == 2) return "B";
        
        
        return numMoves == n*n ? "Draw" : "Pending";
    }
}