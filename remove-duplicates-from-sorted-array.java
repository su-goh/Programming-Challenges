class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
    
        int len = 1;
        int prev = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != prev) {
                nums[len] = nums[i]; 
                prev = nums[i];
                len++;
            } else { // nums[i] == prev, a dup!
                continue;
            }
        }
    
        return len;
    }
}
