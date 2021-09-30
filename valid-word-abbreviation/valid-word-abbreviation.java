class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPtr = 0, abbrPtr = 0;
        
        int num = 0;
        for(int i = 0; i < abbr.length(); i++) {
            char currChar = abbr.charAt(i);
            
            if(Character.isAlphabetic(currChar)) {
                wordPtr += num;
                num = 0;
                
                if(wordPtr >= word.length()) return false;
                if(currChar != word.charAt(wordPtr)) return false;
                wordPtr++;
            } else {
                if(num == 0 && currChar - '0' == 0) return false; // leading 0
                else num = num*10 + (currChar - '0');
            }
            
        }
        
        wordPtr += num;
        
        return wordPtr == word.length() ? true : false;
    }
}