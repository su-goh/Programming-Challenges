class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1;
        int count = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != 0) {
                nums[++i] = nums[j];
                count++;
            }
        }
        
        count = nums.length - count;
        //System.out.println(count);
        
        for(int j = 0; j < count; j++) {
            nums[i+1+j] = 0;
        }
        
    }
}
