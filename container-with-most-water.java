class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        int curr = 0;
        
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                curr = (j-i)*Math.min(height[i], height[j]);
                max = Math.max(max, curr);
            }
        }
        
        return max;
    }
}
