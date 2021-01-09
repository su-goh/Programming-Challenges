class Solution {
    public int findNumbers(int[] nums) {
        int num = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] + "").length()  % 2 == 0) num++;
        }
        
        return num;
    }
}
