class Solution {
    public int numDecodings(String s) {
        int prev = 1, curr = (s.charAt(0) == '0' ? 0 : 1);
        
        for(int i = 2; i <= s.length(); i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i)); 
            int temp = curr;
            curr = 0;
            
            if(one > 0 && one < 10) curr = temp;
            if(two > 9 && two < 27) curr += prev;
            prev = temp;
        }
        
        return curr;
    }
}