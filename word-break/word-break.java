class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(dict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length() - 1];
    }
}