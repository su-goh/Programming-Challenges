class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        int[] prod = new int[nums.length];
        int total = 1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;
            else total *= nums[i];
        }
        
        for(int i = 0; i < prod.length; i++) {
            prod[i] = (zeros > 0) ? (zeros == 1 && nums[i] == 0) ? total : 0 : total/nums[i];
        }
        
        return prod;
    }
}