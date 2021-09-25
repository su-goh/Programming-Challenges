class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder currString = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(currChar == '(') {
                st.push(currString.toString());
                currString = new StringBuilder();
                st.push("(");
            } else if(currChar == ')') {
                st.push(currString.toString());
                currString = new StringBuilder();
                
                while(!st.empty() && !st.peek().equals("(")) {
                    currString.insert(0, st.pop());
                }
                
                if(!st.empty() && st.peek().equals("(")) {
                    currString.insert(0,st.pop());
                    currString.append(")");
                }
                
                st.push(currString.toString());
                currString = new StringBuilder();
                
            } else {
                currString.append(currChar);
            }
        }
        
        st.push(currString.toString());
        currString = new StringBuilder();
        
        while(!st.empty()) {
            if(st.peek().equals("(")) st.pop();
            else currString.insert(0, st.pop());
        }
        
        return currString.toString();
    }
}


// a(b(c)d)
// 
// (
//
// d
// (c)
// b
// a
// 
// de
// (t(c)o)
// lee