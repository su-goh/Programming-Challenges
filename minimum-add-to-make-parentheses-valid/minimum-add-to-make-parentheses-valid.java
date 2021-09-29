class Solution {
    public int minAddToMakeValid(String s) {
        int numOpen = 0, numAdd = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(currChar == '(') numOpen++;
            else if(currChar == ')') {
                if(numOpen > 0) numOpen--;
                else numAdd++;
            }
        }
        
        return numAdd + numOpen;
    }
}