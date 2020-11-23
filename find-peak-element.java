class Solution {
    public int findPeakElement(int[] nums) {
        
        int maxIndex = 0;
        
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
            else {
                maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
            }
        }
        
        maxIndex = nums[nums.length - 1] > nums[maxIndex] ? nums.length - 1 : maxIndex;
        
        return maxIndex;
    }
}
