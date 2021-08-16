class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        
        while(p1 < p2) {
            while(p1 < p2 && !Character.isLetterOrDigit(s.charAt(p1))) p1++;
            while(p1 < p2 && !Character.isLetterOrDigit(s.charAt(p2))) p2--;
            if(p1 >= p2) break;
            
            if(Character.toLowerCase(s.charAt(p1++)) != Character.toLowerCase(s.charAt(p2--))) return false;
        }
        
        return true;
    }
}