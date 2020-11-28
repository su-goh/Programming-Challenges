class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length == 0) return 0;
        
        // sort intervals by start time
        Arrays.sort(intervals, (int[] a, int[] b) -> a[1] - b[1]);
        
        int count = 0, curr = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < curr) count++;
            else curr = intervals[i][1];
        }
​
        return count;
    }
}
