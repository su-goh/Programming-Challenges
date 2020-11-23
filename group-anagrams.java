class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // sort
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String s = String.valueOf(curr);
            
            if(!map.containsKey(s)) map.put(s, new ArrayList<String>());
            map.get(s).add(strs[i]);
        }
     return new ArrayList(map.values());   
    }
        
        // categorize solution
        /**
        if(strs.length == 0) return new ArrayList<>();
        
        Map<String, List> map = new HashMap<>();
        int[] count;
        
        for(int i = 0; i < strs.length; i++) {
            // Construct the String mapping of curr strs
            StringBuilder sb = new StringBuilder();
            count = new int[26];
            char[] currCharArray = strs[i].toCharArray();
            for(int j = 0; j < currCharArray.length; j++) count[currCharArray[j] - 'a'] += 1;
            
            for(int j = 0; j < 26; j++) {
                sb.append(count[j]);
                sb.append("#");
            }
            
            String thisSeq = sb.toString();
            if(!map.containsKey(thisSeq)) map.put(thisSeq, new ArrayList<String>());
            map.get(thisSeq).add(strs[i]);
        }
        
