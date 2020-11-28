class Solution {
    public int strStr(String haystack, String needle) {
        
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        
        //KMP APPROACH
        int[] pattern = KMP(needle);
        int j = 0;
        
        for(int i = 0; i < haystack.length(); i++) {
            
            if (haystack.charAt(i) != needle.charAt(j)) {
                if(j > 0) {
                    j = pattern[j-1];
                    i--;
                }
                continue;
            }
​
            // haystack[i] == needle[j]
            if (j == needle.length() - 1) return i - j;
            else j++;
        }
        
        return -1;
    }
    
    // KMP algorithm O(n) speed and size
    public int[] KMP(String needle) {
        int[] pattern = new int[needle.length()];
        int j = 0;
        
        for(int i = 1; i < needle.length(); i++) {
            // pattern[i] = 0, but already initialized as 0
            if(needle.charAt(i) != needle.charAt(j)) {
                if(j > 0) {
                    j = pattern[j-1];
                    i--;
                }
                continue;
            }
            
            // if needle[i] == needle[j], pattern[i] = j + 1;
            pattern[i] = ++j;
        }
        
        return pattern;
    }
        
        
        //NAIIVE APPROACH 
        
//         if(needle.length() == 0) return 0;
//         if(haystack.length() == 0) return -1; //|| haystack.length() < needle.length()
//         int skip = 0;
​
        
//         for(int i = 0; i < haystack.length(); i++) {
//             // not a match
//             // if (haystack.charAt(i) != needle.charAt(0)) continue;
//             // might be a match
            
//             // if (needle.length() > i + haystack.length()) break;
            
//             for(int j = 0; j < needle.length(); j++) {
                
//                 // surely not a match
//                 //if (haystack.charAt(i+j) != needle.charAt(j));
                
//                 // out bound of i checking
//                  if (i+j == haystack.length()) return -1;
                
