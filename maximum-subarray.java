class Solution {
    public int maxSubArray(int[] nums) {        
        int max = Integer.MIN_VALUE, curr = 0, prev = 0;
        
        for(int i = 0; i < nums.length; i++) {
            prev = curr;
            curr = nums[i] + ((prev > 0) ? prev : 0);
            max = Math.max(max, curr);
        }
        
        return max;
        
    }
}
