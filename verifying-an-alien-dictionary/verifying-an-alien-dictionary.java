class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        
        for(int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            
            int currWordSize = Math.min(word1.length(), word2.length());
            int p = 0;
            while(p < currWordSize) {
                int cmp = orderMap.get(word1.charAt(p)) - orderMap.get(word2.charAt(p));
                if(cmp < 0) break;
                else if(cmp > 0) return false;
                else p++;
            }
            
            if(p == currWordSize && word1.length() > word2.length()) return false;
        }
        
        return true;
    }
}