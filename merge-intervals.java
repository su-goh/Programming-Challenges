class Solution {
    public int[][] merge(int[][] intervals) {
        
        int[][] ret = new int[intervals.length][2];
        int size = 0;
        int[] curr = null;
        
        // sort list!
        Arrays.sort(intervals, (int[] i1, int[] i2) ->  i1[0] - i2[0]);
        
        // use a stack
        for(int i = 0; i < intervals.length; i++) {
            if(curr == null) {
                curr = new int[2];
                curr[0] = intervals[i][0];
                curr[1] = intervals[i][1];
            } else {
                if(intervals[i][0] <= curr[1]){
                    if(intervals[i][1] > curr[1])
                        curr[1] = intervals[i][1];
                }
                    
                else {
                    ret[size++] = curr;
                    curr = new int[2];
                    curr[0] = intervals[i][0];
                    curr[1] = intervals[i][1];
                }
            }
        }
        
        if(curr != null) ret[size++] = curr;
        
        //return intervals;
        return Arrays.copyOfRange(ret, 0, size);
        
    }
}
