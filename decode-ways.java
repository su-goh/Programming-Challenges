class Solution {
    public int numDecodings(String s) {
        
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        
        // if |curr| != "0",
        //      if |curr| <= 6
                    // either |n-1| is 1 or 2, then |n-2| can be taken
                    // else |n-1| == 0 or > 2, then |n-2| CANT be taken
        //      if |curr| > 6
                    // if |n-1| is "1", then |n-2| can be taken
                    // else |n-1| == "0" or >= 2, then |n-2| CANT be taken
        // else |curr| == "0"
        //      |n-1| MUST NOT BE TAKEN
        //      if |n-1| is "1"/"2" then |n-2| can be taken
        //      else |n-1| is "0" or > 2, then return 0
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i < dp.length; i++) {
            int one = Integer.valueOf(s.substring(i-1, i));
            int two = Integer.valueOf(s.substring(i-2, i));
            int currSum = 0;
            
            if(one != 0) {
                currSum += dp[i-1];
            }
            
            if(two <= 26 && s.charAt(i-2) != '0') {
                currSum += dp[i-2];
            }
            
            dp[i] = currSum;
            
        }
        
        return dp[dp.length - 1];
    }
}
