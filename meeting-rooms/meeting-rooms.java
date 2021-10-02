class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return true;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] currTime = intervals[0];
        
        for(int i = 1; i < intervals.length; i++) {
            if(currTime[1] > intervals[i][0]) return false;
            currTime = intervals[i];
        }
        
        return true;
    }
}