class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> li = new ArrayList<>();
        
        // before
        while(i < intervals.length && intervals[i][0] < newInterval[0]) {
            li.add(intervals[i++]);
        }
                
        // insert or merge
        if(i - 1 >= 0 && intervals[i - 1][1] >= newInterval[0]) {
            li.get(i - 1)[1] = Math.max(newInterval[1], li.get(li.size() - 1)[1]);
        } else {
            li.add(newInterval);
        }
                
        // after
        while(i < intervals.length) {
            if(li.get(li.size() - 1)[1] >= intervals[i][0]) {
                li.get(li.size() - 1)[1] = Math.max(li.get(li.size() - 1)[1], intervals[i][1]);
                i++;
            } else li.add(intervals[i++]);
            
        }
        
        return li.toArray(new int[li.size()][2]);
    }
}