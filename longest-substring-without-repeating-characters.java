class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        
        for(int j = 0, i = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                i = Math.max(map.get(c)+1, i);
                
            }
            map.put(c, j);
            maxLen = Math.max(maxLen, j-i+1);
        }
        
        
        
        return maxLen;
    }
}
