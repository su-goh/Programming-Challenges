class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int includeFirst = helper(nums, 0, nums.length-2);
        int excludeFirst = helper(nums, 1, nums.length-1);
        
        
        return Math.max(includeFirst, excludeFirst);
    }
    
    public int helper(int[] nums, int start, int end) {
        int[] dp = new int[2];
        // 0 represents max if choose curr
        // 1 represents max if skip curr
        
        for(int i = start; i <= end; i++) {
            int prevChoose = dp[0];
            int prevSkip = dp[1];
            dp[0] = nums[i] + prevSkip;
            dp[1] = Math.max(prevSkip, prevChoose);
        }
        
        return Math.max(dp[0], dp[1]);
    }
}
