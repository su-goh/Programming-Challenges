class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int arrLen = strs.length;
        
        // Vertical scanning approach
        if (arrLen == 0) return "";
        
        
        // find min len
        int len = strs[0].length();
        for(int i = 0; i < arrLen; i++) {
            int curr = strs[i].length();
            if(curr < len) len = curr;
        }
        
        for(int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for(int j = 0; j < arrLen; j++) 
                if(c != strs[j].charAt(i)) return strs[0].substring(0,i);
        }
        
        return strs[0].substring(0,len);
        
    }
}
