class Solution {
    public int maxProduct(int[] nums) {
        int currMin = nums[0];
        int currMax = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(nums[i], Math.max(currMax*nums[i], currMin*nums[i]));
            currMin = Math.min(nums[i], Math.min(currMin*nums[i], temp*nums[i]));
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}