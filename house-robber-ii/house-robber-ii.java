class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int withPrev1 = nums[0];
        int withoutPrev1 = 0;
        int withPrev2 = nums[1];
        int withoutPrev2 = 0;
        boolean firstSelected = false;
        
        for(int i = 1; i < nums.length - 1; i++) {
            int temp = withPrev1;
            
            withPrev1 = Math.max(withoutPrev1 + nums[i], withPrev1);
            withoutPrev1 = temp;
        }
        
        for(int i = 2; i < nums.length; i++) {
            int temp = withPrev2;
            
            withPrev2 = Math.max(withoutPrev2 + nums[i], withPrev2);
            withoutPrev2 = temp;
        }
        
        return Math.max(Math.max(withPrev1, withoutPrev1), Math.max(withPrev2, withoutPrev2));
    }
}