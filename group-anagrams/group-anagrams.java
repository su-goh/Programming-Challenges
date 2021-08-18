class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for(int j = 0; j < strs[i].length(); j++) {
                count[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < count.length; j++){
                char c = (char)('a' + j);
                sb.append(c + count[j] + "");
            }
            
            if(map.containsKey(sb.toString())) {
                map.get(sb.toString()).add(strs[i]);
            } else {
                map.put(sb.toString(), new ArrayList<>());
                map.get(sb.toString()).add(strs[i]);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}