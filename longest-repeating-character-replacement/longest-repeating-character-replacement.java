class Solution {
    public int characterReplacement(String s, int k) {      
        int p1 = 0, p2 = 0, size = 1, used = 0;
        int maxFreq = 0;
        int[] dp = new int[26];
        
        for(p2 = 0; p2 < s.length(); p2++) {
            char currChar = s.charAt(p2);
            dp[currChar - 'A']++;
            maxFreq = Math.max(maxFreq, dp[currChar - 'A']);            
            int numsLetterChanged = (p2 - p1 + 1) - maxFreq;
            
            if(numsLetterChanged > k) {
                dp[s.charAt(p1) - 'A']--;
                p1++;
            }
            size = Math.max(size, p2 - p1 + 1);

        }
        
        return size;
    }
}