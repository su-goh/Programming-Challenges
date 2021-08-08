class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        
        while(start < end) {
            int currArea = (end - start)*(Math.min(height[start], height[end]));
            maxArea = Math.max(maxArea, currArea);
            if (height[start] < height[end]) start++;
            else end--;
        }
        
        return maxArea;
    }
}