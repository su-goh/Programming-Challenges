                            if(board[startI][startJ] == 1) sum++;
                            startJ++;
                        }
                        startI++;
                    }
                    
                    memo[i][j] = sum;
                } else {
                    // count num 0's
                    int startI = 0;
                    int startJ = 0;
                    if(i != 0) startI = i - 1;
                    else startI = i;
                    
                    int sum = 0;
                    while(startI <= i + 1 && startI < board.length) {
                        if(j != 0) startJ = j - 1;
                        else startJ = j;
                        while(startJ <= j + 1 && startJ < board[0].length) {
                            //System.out.println(startI + " " + startJ);
                            if(startI == i && startJ == j) {
                                startJ++;
                                continue;
                            }
                            if(board[startI][startJ] == 1) sum++;
                            startJ++;
                        }
                        startI++;
                    }
                    
                    memo[i][j] = sum;
                }
            }
        }
        
        // for(int i = 0; i < board.length; i++) {
        //     for(int j = 0; j < board[0].length; j++) {
        //         System.out.print(memo[i][j]);
        //     }
        //     System.out.println();
        // }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0 && memo[i][j] == 3) {
                    board[i][j] = 1;
                } else if (board[i][j] == 1) {
                    if (memo[i][j] < 2 || memo[i][j] > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
        
        
    }
}
