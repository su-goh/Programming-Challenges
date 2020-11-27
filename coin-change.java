class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        // starting from i = 1 -> amount
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] > i) break;
                else dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
