class TicTacToe {
    
    int n;
    HashMap<Integer, HashMap<Integer, Integer>> rows; // rowIndex -> (player -> count)
    HashMap<Integer, HashMap<Integer, Integer>> cols;
    HashMap<Integer, Integer> diagA; // "\" i == j
    HashMap<Integer, Integer> diagB;// "/" i == (n - i - 1)

    public TicTacToe(int n) {
        this.n = n;
        rows = new HashMap<>();
        cols = new HashMap<>();
        diagA = new HashMap<>();
        diagB = new HashMap<>();
    }
    
    public int move(int row, int col, int player) {
        rows.putIfAbsent(row, new HashMap<>());
        rows.get(row).put(player, rows.get(row).getOrDefault(player, 0) + 1);
        if(rows.get(row).get(player) == n) return player;

        cols.putIfAbsent(col, new HashMap<>());
        cols.get(col).put(player, cols.get(col).getOrDefault(player, 0) + 1);
        if(cols.get(col).get(player) == n) return player;
        
        if(row == col) {
            diagA.put(player, diagA.getOrDefault(player, 0) + 1);
            if(diagA.get(player) == n) return player;
         }
        
        if(col == n - row - 1) {
            diagB.put(player, diagB.getOrDefault(player, 0) + 1);
            if(diagB.get(player) == n) return player;
        }
        
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */