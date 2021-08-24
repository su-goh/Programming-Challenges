class Solution {
    public int rob(int[] nums) {
        int withoutPrev = 0;
        int withPrev = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int temp = withPrev;
            
            withPrev = Math.max(withoutPrev + nums[i], withPrev);
            withoutPrev = temp;
        }
        
        return Math.max(withPrev, withoutPrev);
    }
}