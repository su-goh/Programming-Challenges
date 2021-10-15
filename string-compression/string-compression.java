class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        char prevChar = chars[j];
        int currCharCount = 0;
        
        while (j < chars.length) {
            while(j < chars.length && chars[j] == prevChar) {
                j++;
                currCharCount++;
            }
            
            if(currCharCount > 1) {
                chars[i++] = prevChar;
                Stack<Character> st = new Stack<>();
                while(currCharCount != 0) {
                    st.push((char)((currCharCount % 10) + '0'));
                    currCharCount /= 10;
                }
                while(!st.isEmpty()) chars[i++] = st.pop();
            } else chars[i++] = prevChar;
            
            if(j < chars.length) prevChar = chars[j];
            currCharCount = 0;
            
        }
        
        return i;
    }
}