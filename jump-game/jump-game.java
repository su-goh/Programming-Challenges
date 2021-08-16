class Solution {
    public boolean canJump(int[] nums) {
        int maxSpot = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            maxSpot = (i <= maxSpot) ? Math.max(maxSpot, i + nums[i]) : 0;
        }
        
        return (maxSpot >= nums.length - 1) ? true : false;
    }
}