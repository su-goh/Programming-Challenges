class Solution {
    public int maxArea(int[] height) {
        
//         int max = 0;
//         int curr = 0;
        
//         for(int i = 0; i < height.length; i++) {
//             for(int j = i + 1; j < height.length; j++) {
//                 curr = (j-i)*Math.min(height[i], height[j]);
//                 max = Math.max(max, curr);
//             }
//         }
        
//         return max;
        
        
        int p1 = 0;
        int p2 = height.length - 1;
        int max = 0;
        
        while(p1 < p2) {
            int curr = Math.min(height[p1], height[p2])*(p2-p1);
            max = Math.max(max, curr);
            if(height[p1] < height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        
        return max;
    }
}
