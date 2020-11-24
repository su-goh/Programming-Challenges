class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int currSum = 0, sum = 0, start = 0;
        
        for(int i = 0; i < gas.length; i++) {
            currSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            
            if (currSum < 0) {
                currSum = 0;
                start = i+1;
            }
        }
        
        if(sum < 0) return -1;
        else return start;
    }
}
