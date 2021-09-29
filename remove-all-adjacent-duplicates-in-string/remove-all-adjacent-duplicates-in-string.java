class Solution {
    public String removeDuplicates(String s) {
        StringBuilder validString = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            
            if(validString.length() == 0) validString.append(currChar);
            else if(validString.charAt(validString.length() - 1) == currChar) 
                validString.deleteCharAt(validString.length() - 1);
            else validString.append(currChar);
        }
                
        return validString.toString();
    }
}