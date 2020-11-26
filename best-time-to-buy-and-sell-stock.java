class Solution {
    public int maxProfit(int[] prices) {
        //int[] dp = new int[prices.length];
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        
        return maxProfit;
    }
}
