class Solution {
    public boolean validPalindrome(String s) {
        return isValindrome(s, 0, s.length() - 1, 0);
    }
    
    private boolean isValindrome(String s, int start, int end, int numRemove) {
        
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                if(numRemove >= 1) return false;
                return isValindrome(s, start + 1, end, 1) || isValindrome(s, start, end - 1, 1);
            } else {
                start++;
                end--;
            }
        }
        
        return true;
    }
}