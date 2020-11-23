class Solution {
    String word;
    
    public boolean exist(char[][] board, String word) {
        this.word = word;
        //int[][] oriBoard = board;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(i, j, 0, Arrays.copyOf(board, board.length))) return true;
                }
            }
        }
        
        // for(int i = 0; i < board.length; i++) {
        //     for(int j = 0; j < board[0].length; j++) System.out.print(board[i][j]);
        //     System.out.println();
        // }
        // System.out.println();
        
        return false;
    }
    
    public boolean helper(int currR, int currC, int currChar, char[][] currBoard){
        
        
         // System.out.println(word.charAt(currChar));
        
        // base case
        if(currChar == word.length() - 1) {
            if(currBoard[currR][currC] == word.charAt(currChar)) {
                return true;
            }
            // System.out.println(currBoard[currR][currC]);
            return false;
        }
        
        currBoard[currR][currC] = '0';
        
        // look at right
