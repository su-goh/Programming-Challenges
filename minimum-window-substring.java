class Solution {
    public String minWindow(String s, String t) {
        
        if(s == null | s.length() == 0 || t.length() == 0 || t.length() > s.length())
            return "";
        
        int bestLeft = 0, bestRight = s.length()-1, bestLen = Integer.MAX_VALUE;
        int l = 0; // two pointers
        int count = 0; // num Occurance of elements in t
        
        // turn t into a mapping for easy access
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(int i = 0; i < t.length(); i++) {
            int temp = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), temp + 1);
        }
        
        
        for(int r = 0; r < s.length(); r++) {
            // move pointer R such that all elements in T are identified
            Character currCharOfR = s.charAt(r);
            
            // curr Char of R is an element of T
            if(map.containsKey(currCharOfR)) {
                int currCharOfRFreq = map.get(currCharOfR);
                map.put(currCharOfR, currCharOfRFreq-1);
                
                // record how many elements in T has been identified
                if(currCharOfRFreq - 1 >= 0) count++; 
                
                // we found ALL elements in T for this substring, (l,r)
                while(count == t.length()) {
                    if(r - l + 1 < bestLen) {
                        bestLen = r - l + 1;
                        bestRight = r;
                        bestLeft = l;
                    }
                    
                    Character currCharOfL = s.charAt(l);
                    
                    // update occurence of charAt(l)
                    if(map.containsKey(currCharOfL)) {
                        int currCharOfLFequency = map.get(currCharOfL);
                        map.put(currCharOfL, currCharOfLFequency + 1);
                        
                        if(currCharOfLFequency + 1 > 0) {
                            count--;
                        }
                    }
                    
                    l++;
                }
            }
        }
        
        if(bestLen == Integer.MAX_VALUE) return "";
        return s.substring(bestLeft, bestRight + 1);
    }
    
}
