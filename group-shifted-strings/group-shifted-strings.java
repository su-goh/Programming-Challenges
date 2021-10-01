class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strings.length; i++) {
            String currString = strings[i];
            StringBuilder currSb = new StringBuilder();
            char prevChar = currString.charAt(0);
            currSb.append("0");
            
            for(int j = 1; j < currString.length(); j++) {
                char currChar = currString.charAt(j);
                int diff = currChar - prevChar;
                if(diff < 0) diff += 26;
                currSb.append(diff + ",");
                prevChar = currChar;
            }
            
            String currCode = currSb.toString();
            if(!map.containsKey(currCode)) {
                map.put(currCode, new ArrayList<String>());
                ret.add(map.get(currCode));
            }
            map.get(currCode).add(currString);
        }
        
        return ret;
    }
}