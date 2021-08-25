class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        Set<Character> set = new HashSet<>();
        int p1 = 0, p2 = 0;
        int bp1 = 0, bp2 = 0;
        
        for(p2 = 0; p2 < s.length(); p2++) {
            char currChar = s.charAt(p2);
            if(!set.contains(currChar)) {
                set.add(currChar);
                if((bp2 - bp1) < (p2 - p1)) {
                    bp2 = p2;
                    bp1 = p1;
                }
            }
            else {
                char removed;
                do {
                    removed = s.charAt(p1);
                    set.remove(s.charAt(p1));
                    p1++;
                } while(removed != currChar);
                set.add(currChar);
            }
        }
        
        return bp2 - bp1 + 1;
    }
}