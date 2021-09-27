class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new LinkedList<>();
        HashSet<String> ignore = new HashSet<>(Arrays.asList(".", "..", ""));
        
        for(String curr : path.split("/")) {
            if(curr.equals("..") && st.size() > 0) st.pop();
            else if(ignore.contains(curr)) continue;
            else st.push(curr);
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0) sb.append("/" + st.pollLast());
        
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}