class Solution {
    public int partitionK(int n, int k) {

        if(n < k) return -1;

        int[][] dp = new int[n][k];

        // if k (size) == 0, then there's no way to partition, 
        // dont have to do this because this is handled by java
        for(int i = 0; i <= n; i++) dp[i][0] = 0;

        // if k (size) == 1, then there's only one way to partition
        for(int i = 0; i <= n; i++) dp[i][1] = i;

        // ??
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 2; j <= k; j++) {
                dp[i][j] = dp[i-1][j-1];
                if(i >= 2*j)  dp[i][j] += dp[i-j][j];
            }
        }

        return dp[n][k];
    }
}