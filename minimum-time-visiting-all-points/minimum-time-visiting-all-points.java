class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int[] curr = points[0];
        
        for(int i = 1; i < points.length; i++) {
            int diffX = Math.abs(points[i][0] - curr[0]);
            int diffY = Math.abs(points[i][1] - curr[1]);
            
            time += Math.max(diffX, diffY);
            
            curr = points[i];
        }
        
        return time;
        
    }
}
