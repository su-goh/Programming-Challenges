class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] degree = new int[n];
        
        for(int i = 0; i < roads.length; i++) {
            int ct1 = roads[i][0], ct2 = roads[i][1];
            degree[ct1]++;
            degree[ct2]++;
            connected[ct1][ct2] = true;
            connected[ct2][ct1] = true;
        }
        
        int maxDegree = 0;
        for(int i = 0; i < degree.length; i++) {
            for(int j = i + 1; j < degree.length; j++) {
                maxDegree = Math.max(maxDegree, degree[i] + degree[j] - (connected[i][j] ? 1 : 0));
            }
        }
        
        return maxDegree;
    }
}