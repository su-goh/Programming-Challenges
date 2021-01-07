class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ret = 0;
        
        // BASE CASE: SINGLE LETTERS
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            ret++;
        }
        
        // BASE CASE: DOUBLE LETTERS
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                ret++;
            }
        }
        
        for(int len = 2; len < s.length(); len++) {
            for(int i = 0; i < s.length(); i++) {
                if(i+len >= s.length()) break;
                else {
                    dp[i][i+len] = (s.charAt(i) == s.charAt(i+len) && dp[i+1][i+len-1]);
                    if(dp[i][i+len] == true) ret++;
                }
            }
        }
               
        return ret;
    }
}
