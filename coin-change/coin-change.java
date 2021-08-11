class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
                
        for(int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) dp[coins[i]] = 1;
        }
        
        for(int i = 1; i < dp.length; i++) {
            int currMin = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] < 0 || dp[i - coins[j]] < 0) continue;
                currMin = Math.min(currMin, 1 + dp[i - coins[j]]);
            }
            dp[i] = currMin == Integer.MAX_VALUE ? -1 : currMin;
        }
        
        // for(int i = 0; i < dp.length; i++) System.out.println(dp[i]);
        
        return dp[amount];
    }
}