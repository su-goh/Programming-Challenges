class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 0;
        int numZero = 0;
        int[] ret = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) total = total == 0 ? nums[i] : total*nums[i];
            else numZero++;
        }
                
        
        for(int i = 0; i < ret.length; i++) {
            if(nums[i] != 0 && numZero == 0) ret[i] = total/nums[i];
            else if (nums[i] != 0 && numZero > 0 || numZero > 1) ret[i] = 0;
            else if (nums[i] == 0 && numZero > 0) ret[i] = total;
        }
        
        return ret;
    }
}