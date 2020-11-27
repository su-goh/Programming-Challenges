class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        
        // starting from i = 1 -> amount
        for(int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] > i) break;
                else {
                    int prev = dp[i - coins[j]];
                    if(prev == Integer.MAX_VALUE) {
                        dp[i] = dp[i];
                    } else {
                        dp[i] = Math.min(dp[i], 1 + prev);
                    }
                }
            }
        }
        
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}
