class Solution {
    public int calculate(String s) {
        // 3 + 2 - 8 * 5 / 3 = ??
        
        // prev is -, prevNum = prev - sum;
        // prev is +, prevNum = sum - prev
        
        
        int sum = 0, currNum = 0;
        char sign = '+';
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                currNum = currNum*10 + c - '0';
            
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                operation(sign, currNum, st);
                currNum = 0;
                sign = c;
            }
        }
        
        while(!st.empty()) sum += st.pop();
          
        return sum;
    }
    
    private void operation(char sign, int currNum, Stack<Integer> st) {
        if(sign == '+') st.push(currNum);
        else if(sign == '-') st.push(-currNum);
        else if(sign == '*') st.push(st.pop()*currNum);
        else if(sign == '/') st.push(st.pop()/currNum);
        System.out.println(st.peek());
    }
    
    
    private int calcSum(int sign, int sum, int currNum) {
        // 1 == +, 2 == -, 3 == *, 4 == /
        if(sign == 1) {
            return sum + currNum;
        } else if (sign == 2) {
            return sum - currNum;
        } else if (sign == 3) {
            return sum * currNum;
        } else {
            return sum / currNum;
        }
    }
}