class Solution {
    public int[][] merge(int[][] intervals) {
        
        int[][] ret = new int[intervals.length][2];
        int size = 0;
        
        // sort list!
        Arrays.sort(intervals, (int[] i1, int[] i2) ->  i1[0] - i2[0]);
        
        // use a stack
        for(int i = 0; i < intervals.length; i++) {
            // if size == 0 or there is no overlap, put inside list
            if(size == 0 || ret[size - 1][1] < intervals[i][0])
                ret[size++] = intervals[i];
            else // there's overlap
                ret[size - 1][1] = Math.max(ret[size-1][1], intervals[i][1]);
        }
                
        return Arrays.copyOfRange(ret, 0, size);
        
    }
}
