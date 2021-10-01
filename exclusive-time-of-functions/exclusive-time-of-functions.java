class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] excl = new int[n];   
        Stack<int[]> st = new Stack<>();

        for(int i = 0; i < logs.size(); i++) {
            String[] currProc = logs.get(i).split(":");
            int proc = Integer.parseInt(currProc[0]);
            int time = Integer.parseInt(currProc[2]);
            boolean isStart = currProc[1].equals("start");
            
            if(isStart) {
                st.push(new int[]{proc, time});
            } else {
                int[] prevProc = st.pop();
                int len = time - prevProc[1] + 1;
                excl[proc] += len;
                if(!st.isEmpty()) excl[st.peek()[0]] -= len;
            }
        }
        
        return excl;
    }
}