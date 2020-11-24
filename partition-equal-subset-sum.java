class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if(sum % 2 != 0) return false;
        else sum /= 2;
        
        boolean[][] dp = new boolean[nums.length + 1][sum+1];
        // for(int i = 0; i < sum; i++) {
        //     dp[nums.length][i] = true;
        // }
        
        for(int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        
        
        for(int i = nums.length - 1; i >= 0; i--) {
            for(int j = 0; j <= sum; j++) {
                
                // if(nums[i] > j) {
                dp[i][j] = dp[i+1][j];
                if(nums[i] <= j) {
                    dp[i][j] = dp[i][j] || dp[i+1][j-nums[i]];
                    // System.out.println("hey " + j + " " + (nums[i]));
                }
                // System.out.println(i + " " + j + ": " + dp[i][j]);
            }
        }
        
        return dp[0][sum];
    }
}
