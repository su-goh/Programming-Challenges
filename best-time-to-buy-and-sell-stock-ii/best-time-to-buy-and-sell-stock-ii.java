class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0) return 0;
        
        int cash = 0, hold = cash - prices[0];
        
        for(int i = 0; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i]);
            hold = cash - prices[i];
        }
        
        return cash;
    }
}
