class Solution {
    public String longestPalindrome(String s) {
        int x = 0, y = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int len = 0; len < s.length(); len++) {
            int currX = 0, currY = currX + len;
            while(currY < s.length()) {

                if(s.charAt(currX) == s.charAt(currY) && (len - 2 < 0 || dp[len - 2][currX + 1])) {
                    dp[len][currX] = true;
                    x = currX;
                    y = currY;
                }
                currY++;
                currX++;
            }
        }
        
        
        
        return s.substring(x, y+1);
    }
}