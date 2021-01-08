class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        
        if(S > 1000) return 0;
        
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        
        for(int i = 1; i < nums.length; i++) {
            int[] temp = new int[2001];
​
            for(int sum = -1000; sum <= 1000; sum++) {
                if(dp[sum+1000] > 0) {
                    temp[sum + nums[i] + 1000] += dp[sum+1000];
                    temp[sum - nums[i] + 1000] += dp[sum+1000];
                }
            }
            dp = temp;
        }
                
        return dp[S + 1000];
    }
}
