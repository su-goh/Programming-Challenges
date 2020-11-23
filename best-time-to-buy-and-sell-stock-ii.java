class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProf = 0;
        
        for(int i = 1; i < prices.length; i++) {
            int prof = prices[i] - prices[i-1];
            if (prof > 0) {
                maxProf += prof;
            }
        }
        return maxProf;
    }
}
