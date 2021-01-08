class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ret = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int count = map.size();
        int begin = 0, end = 0;
        
        while(end < s.length()) {
            Character c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count--;
            }
            
            end++;
            while(count == 0) {
                Character cx = s.charAt(begin);
                if(map.containsKey(cx)) {
                    map.put(cx, map.get(cx) + 1);
                    if(map.get(cx) > 0) count++;
                }
                                
                if((end - begin) == p.length()) ret.add(begin);
                begin++;
            }
        }
        
        return ret;
    }
}
