class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] excl = new int[n];   
        Stack<Log> st = new Stack<>();

        for(int i = 0; i < logs.size(); i++) {
            Log currProc = new Log(logs.get(i));
            if(currProc.isStart) {
                st.push(currProc);
            } else {
                Log prevProc = st.pop();
                excl[currProc.proc] += currProc.time - prevProc.time + 1;
                if(!st.isEmpty()) excl[st.peek().proc] -= (currProc.time - prevProc.time + 1);
            }
        }
        
        return excl;
    }
    
    private class Log{
        int time;
        int proc;
        boolean isStart;
        
        public Log(String s) {
            String[] currProc = s.split(":");
            proc = Integer.parseInt(currProc[0]);
            time = Integer.parseInt(currProc[2]);
            isStart = currProc[1].equals("start");
        }
    }
}