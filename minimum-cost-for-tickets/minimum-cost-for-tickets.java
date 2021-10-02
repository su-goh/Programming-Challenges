class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        
        Set<Integer> travelDays = new HashSet<>();
        for(int day: days) travelDays.add(day);
        
        for(int i = 1; i < dp.length; i++) {
            if(!travelDays.contains(i)) dp[i] = (i - 1) > 0 ? dp[i - 1] : 0;
            else {
                int prevCost = (i - 1) > 0 ? dp[i - 1] : 0;
                int sevenCost = (i - 7) > 0 ? dp[i - 7] : 0;
                int thirtyCost = (i - 30) > 0 ? dp[i - 30] : 0;
                
                dp[i] = Math.min(prevCost + costs[0], Math.min(sevenCost + costs[1], thirtyCost + costs[2]));
            }
        }
        
        return dp[dp.length - 1];
    }
}