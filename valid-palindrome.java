class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() -1;
        
        while(i < j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            
            char iC = /*Character.isLetter(s.charAt(i)) ?*/ Character.toLowerCase(s.charAt(i)); //: s.charAt(i);
            char jC = /*Character.isLetter(s.charAt(j)) ?*/ Character.toLowerCase(s.charAt(j)); //: s.charAt(j);
            //System.out.println(iC + " " + jC);
            if(iC != jC) return false;
            
            
            i++;
            j--;
        }
        return true;
    }
}
