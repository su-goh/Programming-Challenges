class Solution {
    public String reverseWords(String s) {
        Scanner scnr = new Scanner(s);
        Stack<String> st = new Stack<>();
        
        while(scnr.hasNext()) {
            String next = scnr.next();
            st.add(next);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
            if(!st.isEmpty()) sb.append(" ");
        }
        
        return sb.toString();
        
    }
}