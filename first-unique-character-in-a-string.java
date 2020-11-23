class Solution {
    public int firstUniqChar(String s) {
        
        // Array Map approach
        int[] arr = new int[26];
        char[] c = s.toCharArray();
        int len = c.length;
        
        for(int i = 0; i < len; i++) arr[c[i] - 'a'] += 1;
        for(int i = 0; i < len; i++) if(arr[c[i] - 'a'] == 1) return i;
        
        return -1;
        
        /**
        
        // Two Hash Approach
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        Set<Character> set = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                if (map.get(c) != null) map.remove(c);
            } else {
                set.add(c);
                map.put(c, i);
            }
        }
        
        return (map.size() == 0) ? -1 : map.entrySet().iterator().next().getValue();
        **/
        
        
        /**
        
        // HashMap Approach
        
        if(s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        
        return -1;
        
        **/
    }
}
