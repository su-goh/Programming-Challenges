class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int numRooms = 0;
        List<int[]> rooms = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for(int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            boolean isAssigned = false;
            
            for(int j = 0; j < rooms.size(); j++) {
                if(rooms.get(j)[1] <= currInterval[0]) {
                    rooms.set(j, currInterval);
                    isAssigned = true;
                    break;
                }
            }
            
            if(!isAssigned) {
                rooms.add(currInterval);
            }
        }
        
        return rooms.size();
    }
}