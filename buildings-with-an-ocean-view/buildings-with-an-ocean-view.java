class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> buildings = new Stack<>();
        int currMax = 0;
        
        for(int i = heights.length - 1; i >= 0; i--) {
            if(heights[i] > currMax) {
                currMax = heights[i];
                buildings.push(i);
            }
        }
        
        int[] ret = new int[buildings.size()];
        int i = 0;
        while(!buildings.isEmpty()) ret[i++] = buildings.pop();
        
        return ret;
    }
}