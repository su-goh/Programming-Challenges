class Solution {
    public int maxProfit(int[] prices) {
        int prof = 0;
        int lowest = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest) lowest = prices[i];
            prof = Math.max(prof, prices[i] - lowest);
        }
        
        return prof;
    }
}