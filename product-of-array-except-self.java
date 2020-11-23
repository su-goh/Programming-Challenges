class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int[] before = new int[nums.length];
        before[0] = 1;
        int[] after = new int[nums.length];
        after[nums.length - 1] = 1;
        
        for(int i = 1; i < nums.length; i++) {
            before[i] = nums[i-1]*before[i-1];
        }
        
        for(int j = nums.length - 2; j >= 0; j--) {
            after[j] = nums[j+1]*after[j+1];
        }
        
        for(int i = 0; i < ret.length; i++){
            ret[i] = after[i]*before[i];
        }
        
        return ret;
        
    }
}
