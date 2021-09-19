class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> newIntervals = new ArrayList<>();
        int[] currInterval = new int[]{intervals[0][0], intervals[0][1]};
        
        for(int i = 1; i < intervals.length; i++) {
            if(currInterval[1] < intervals[i][0]) {
                newIntervals.add(currInterval);
                currInterval = new int[]{intervals[i][0], intervals[i][1]};
            } else {
                currInterval[0] = Math.min(currInterval[0], intervals[i][0]);
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
            }
        }
        
        newIntervals.add(currInterval);
        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }
}