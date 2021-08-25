class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        
        int p1 = 0, p2 = 0;
        int bp1 = 0, bp2 = Integer.MAX_VALUE;
        int matched = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        // prepare map
        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        for(p2 = 0; p2 < s.length(); p2++) {
            Character currChar = s.charAt(p2);
            if(map.containsKey(currChar)) {
                int currCharCount = map.get(currChar) - 1;
                map.put(currChar, currCharCount);
                if(currCharCount >= 0) matched++;
            }
            
            while(matched == t.length() && p1 < s.length()) {
                if((bp2 - bp1) > (p2 - p1)) {
                    bp2 = p2;
                    bp1 = p1;
                }
                
                currChar = s.charAt(p1);
                // System.out.println(currChar + " " + bp1 + " " + bp2 + " " + p1 + " " + p2);
                if(map.containsKey(currChar)) {
                    int currCharCount = map.get(currChar) + 1;
                    // System.out.println(currChar + " " + currCharCount);
                    map.put(currChar, currCharCount);
                    if(currCharCount > 0) matched--;
                }
                p1++;
            }
        }
        
        return bp2 == Integer.MAX_VALUE ? "" : s.substring(bp1, bp2 + 1);
    }
}