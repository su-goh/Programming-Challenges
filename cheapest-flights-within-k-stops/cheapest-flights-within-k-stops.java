class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        for(int i = 0; i < n; i++) cost[i] = Integer.MAX_VALUE;
        cost[src] = 0;
        
        for(int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for(int[] flight : flights) {
                int u = flight[0], v = flight[1], price = flight[2];

                if(cost[u] == Integer.MAX_VALUE) continue;
                temp[v] = Math.min(temp[v], cost[u] + price);
            }
            cost = temp;
        }
        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}