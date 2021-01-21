class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                if(num != 0) sb.append(S.charAt(i));
                num++;
            }
            else if(S.charAt(i) == ')') {
                if(num != 1) sb.append(S.charAt(i));
                num--;
            }
        }
        
        return sb.toString();
    }
}
