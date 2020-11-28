class Solution {
        
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> ret = new ArrayList<String>();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ret);
            }
        }
        
        return ret;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> ret) {
        
        char currChar = board[i][j];
​
        // base case
        if(currChar == '0' || node.child[currChar - 'a'] == null) return;
        node = node.child[currChar - 'a']; // traverse trie tree
        String currWord = node.word;
        if(currWord != null && !ret.contains(currWord)) ret.add(currWord);
        
        board[i][j] = '0'; // mark as visited
        
        // go up
        if(i > 0) dfs(board, i-1, j, node, ret);
        
        // go down
        if(i < board.length - 1) dfs(board, i+1, j, node, ret);
        
        // go left
        if(j > 0) dfs(board, i, j-1, node, ret);
        
        // go right
        if(j < board[0].length - 1) dfs(board, i, j+1, node, ret);
        
        board[i][j] = currChar; // restore board
    }
