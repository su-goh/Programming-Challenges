class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '(') stk.push(')');
            else if (s.charAt(i) == '[') stk.push(']');
            else if (s.charAt(i) == '{') stk.push('}');
            else if (stk.isEmpty() || stk.pop() != s.charAt(i)) return false;
            
            // SLOWER
            // if(stk.isEmpty()) stk.push(s.charAt(i));
            // else {
            //     if (stk.peek() == s.charAt(i) - 1 || stk.peek() == s.charAt(i) - 2) stk.pop();
            //     else stk.push(s.charAt(i));
            // }
        }
​
        return stk.isEmpty();
    }
}
