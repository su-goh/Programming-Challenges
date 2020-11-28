class Solution {
    public int numDecodings(String s) {
        
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        
        // if |curr| != "0",
        //      if |curr| <= 6
                    // either |n-1| is 1 or 2, then |n-2| can be taken
                    // else |n-1| == 0 or > 2, then |n-2| CANT be taken
        //      if |curr| > 6
                    // if |n-1| is "1", then |n-2| can be taken
                    // else |n-1| == "0" or >= 2, then |n-2| CANT be taken
        // else |curr| == "0"
        //      |n-1| MUST NOT BE TAKEN
        //      if |n-1| is "1"/"2" then |n-2| can be taken
        //      else |n-1| is "0" or > 2, then return 0
        
        // num ways to decode the nth character (1-indexed)
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // base case
        dp[1] = 1; // base case
        
        // iterative case
        for(int i = 2; i < dp.length; i++) {
            // the int representing the ith int alone
            int one = Integer.valueOf(s.substring(i-1, i));
            // the int representing two digits
            int two = Integer.valueOf(s.substring(i-2, i));
            int currSum = 0;
            
            // one must NOT be 0, because 0 cant be stand on its own
            // if one is not 0, then any number is valid
            if(one != 0) currSum += dp[i-1];
            
            // two must not be 0, else we have two consequences '0'
            // then there's no way to represent message with such arrangement
            if(two == 0) return 0;
            
            // if two is bigger than 26, it is invalid
            // else two is smaller than 27, but check if the first digit
            // is '0', if '0', then these two digit doesn't work
            else if(two <= 26 && s.charAt(i-2) != '0') {
                currSum += dp[i-2];
            }
            
            dp[i] = currSum;
            
        }
        
        return dp[dp.length - 1];
    }
}
