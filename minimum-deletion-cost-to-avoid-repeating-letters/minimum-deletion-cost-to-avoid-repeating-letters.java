class Solution {
    public int minCost(String s, int[] cost) {
        int totalCost = 0;
        
        int i = 0, j = 0;
        while(i < cost.length) {
            int currTotalCost = 0;
            int currMaxCost = 0;
            while(j < cost.length && s.charAt(i) == s.charAt(j)) {
                currTotalCost += cost[j];
                currMaxCost = Math.max(currMaxCost, cost[j]);
                j++;
            }
            
            totalCost += (currTotalCost - currMaxCost);
            i = j;
        }
        
        return totalCost;
    }
}