class Solution {
    public boolean isValidSudoku(char[][] board) {
        
         boolean[] row = new boolean[9], col = new boolean[9], sq = new boolean[9];
         boolean valid = true;
        
        // accessing row of the 2D array, inspecting rows
        for(int i = 0; i < board.length; i++) {
            
            row = new boolean[9];
            col = new boolean[9];
            sq = new boolean[9];
            
            for(int j = 0; j < board[i].length; j++) {
                
                int num = board[i][j] - 48 - 1;
                // row
                if(num != -3) {
                    if(row[num] == true) return false; 
                    else row[num] = true;
                }

                num = board[j][i] - 48 - 1;
                //col
                if(num != -3) {
                    if(col[num] == true) return false;
                    else col[num] = true;    
                }

                int r = i / 3 * 3 + j / 3, c = i % 3 * 3 + j % 3;
                num = board[r][c] - 48 - 1;
                //sq
                if(num != -3) {
                    if (sq[num] == true) return false;
                    else sq[num] = true;
                }

            }
        }
        
        //-----
        
//         // accessing cols of the 2D array, inspecting cols
//         for(int j = 0; j < board.length; j++) {
//             row = new boolean[9];
//             for(int i = 0; i < board[j].length; i++) {
//                 int num = board[i][j] - 48 - 1;
//                 if( num == -3) {
//                     continue;
//                 }else if(row[num] == true) {
//                     return false;
//                 } else {
//                     row[num] = true;
//                 }
//             }
//         }
        
//         // accessing squares of the 2D array, inspecting square
//         for(int i = 0; i < board.length; i++) {
//             row = new boolean[9];
//             for(int j = 0; j < board.length; j++) {
//                 int r = i / 3 * 3 + j / 3, c = i % 3 * 3 + j % 3;
//                 int num = board[r][c] - 48 - 1;
//                 if (num == -3) {
//                     continue;
//                 } else if (row[num] == true) {
//                     return false;
//                 } else {
//                     row[num] = true;
//                 }
//             }
//         }
        
        
        

//         for(int i = 0; i < 9; i++) {
//             HashSet<Character> rset = new HashSet<>(), hset = new HashSet<>(), bset = new HashSet<>();
            
//             for(int j = 0; j < 9; j++) {
//                 int r = i / 3 * 3 + j / 3, c = i % 3 * 3 + j % 3;
                
//                 if(board[i][j] != '.' && !rset.add(board[i][j])) return false;
//                 if(board[j][i] != '.' && !hset.add(board[j][i])) return false;
//                 if(board[r][c] != '.' && !bset.add(board[r][c])) return false;        
//             }
//         }
    
        
        
    return valid;
    }
}
