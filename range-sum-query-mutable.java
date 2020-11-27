class NumArray {
    
    int[] dp;
    int[] nums;
​
    public NumArray(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length + 1];
        buildDP(nums);
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        
        for(int j = i+1; j < dp.length; j++) {
            dp[j] = dp[j] + diff;
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
    
    public void buildDP(int[] nums) {
        int sum = 0;
        for(int i = 1; i <= nums.length; i++) {
            dp[i] = nums[i-1] + dp[i-1];
        }
    }
}
​
