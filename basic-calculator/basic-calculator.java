class Solution {
    public int calculate(String s) {
//         int result = 0;
//         StringBuilder currNum = new StringBuilder();
//         int operation = -1; // -1: inv, 0: add, 1: sub
//         Stack<String> st = new Stack<>();
        
//         for(int i = 0; i < s.length(); i++) {
//             char currChar = s.charAt(i);
//             if(currChar == ' ') continue;
//             else if(currChar == '+' || currChar == '-' || currChar == '(' || currChar == ')') {
//                 if(currNum.length() > 0) {
//                     st.push(currNum.toString());
//                     currNum = new StringBuilder();
//                 }
//                 st.push(currChar + "");
//             }
//             else currNum.append(currChar);
//         }
//         if(currNum.length() != 0) st.push(currNum.toString());
        
        int result = 0;
        int currNumber = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)) {
                currNumber = currNumber * 10 + ((int) currChar - '0');
            } else if(currChar == '+') {
                result += sign*currNumber;
                currNumber = 0;
                sign = 1;
            } else if(currChar == '-') {
                result += sign*currNumber;
                currNumber = 0;
                sign = -1;
            } else if(currChar == '(') {
                st.push(result);
                st.push(sign);
                sign = 1;
                result = 0;
            } else if(currChar == ')') {
                result += sign*currNumber;
                result *= st.pop();
                result += st.pop();
                currNumber = 0;
                sign = 1;
                // System.out.println(result);
            }
        }
        
        if(currNumber > 0) result += sign*currNumber;
        
        return result;
    }
}