class Solution {
    public int trap(int[] height) {
        int water = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        
        while(left < right) {
            if(leftMax < rightMax) {
                water += leftMax - height[left++];
                leftMax = Math.max(leftMax, height[left]);
            } else {
                water += rightMax - height[right--];
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        
        
        return water;
    }
}