class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int[] curr = points[0];
        
        for(int i = 1; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            if(curr[0] == x && curr[1] == y) {
                continue;
            } else if (curr[0] == x && curr[1] != y) {
                time += Math.abs(curr[1] - y);
                curr = points[i];
            } else if (curr[0] != x && curr[1] == y) {
                time += Math.abs(curr[0] - x);
                curr = points[i];
            } else if (curr[0] != x && curr[1] != y) {
                int dirX = Math.abs(x - curr[0]);
                int dirY = Math.abs(y - curr[1]);
                if(dirX == dirY) {
                    time += dirX;
                    curr = points[i];
                } else if (dirX > dirY) {
                    time += dirX;
                    curr = points[i];
                } else if (dirX < dirY) {
                    time += dirY;
                    curr = points[i];
                }
                
            }
        }
        
        return time;
        
    }
}
