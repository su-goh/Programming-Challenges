class Solution {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for(int i = 0; i < tiles.length(); i++) count[tiles.charAt(i) - 'A'] += 1;
        return dfs(count);
    }
    
    public int dfs(int[] count) {
        int sum = 0;
        
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0) continue;
            sum++;
            count[i]--;
            sum += dfs(count);
            count[i]++;
        }
        
        return sum;
    }
}
