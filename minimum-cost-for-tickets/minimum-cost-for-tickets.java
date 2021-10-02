class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Queue<int[]> weekPass = new LinkedList<>(), monthPass = new LinkedList<>();
        int cost = 0;
        
        for(int day : days) {
            while(weekPass.size() > 0 && weekPass.peek()[0] < day) weekPass.poll();
            while(monthPass.size() > 0 && monthPass.peek()[0] < day) monthPass.poll();
            
            weekPass.add(new int[]{day + 6, cost + costs[1]});
            monthPass.add(new int[]{day + 29, cost + costs[2]});

            cost = Math.min(cost + costs[0], Math.min(weekPass.peek()[1], monthPass.peek()[1]));
        }
        
        return cost;
    }
}