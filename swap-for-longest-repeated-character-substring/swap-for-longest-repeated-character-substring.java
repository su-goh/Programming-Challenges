class Solution {
    public int maxRepOpt1(String text) { 
        HashMap<Character, List<Integer>> indices = new HashMap<>(); // c -> [indices]
        for(int i = 0; i < text.length(); i++) {
            indices.putIfAbsent(text.charAt(i), new ArrayList<>());
            indices.get(text.charAt(i)).add(i);
        }
        
        int len = 0;
        int i = 0, j = 0, numSkip = 0;
        while(i < text.length()) {
            int k = - 1;
            while(j < text.length() && (text.charAt(j) == text.charAt(i) || k == -1)) {
                if(text.charAt(j) != text.charAt(i)) k = j;
                j++;
            }
            
            List<Integer> currIndices = indices.get(text.charAt(i));
            for(int idx : currIndices) {
                if(idx < i || idx >= j) {
                    len = Math.max(len, j - i);
                    if(j == text.length() && k == -1) len = Math.max(len, j - i + 1);
                    break;
                }
            }
            
            if(k > -1  && k != j - 1) {
                len = Math.max(len, j - i - 1);
            } else if (k != -1) {
                len = Math.max(len, k - i);
            } else {
                len = Math.max(len, j - i);
            }
            
            if(k == -1) i = j;
            else {
                i = k;
                j = i;
            }
        }
        
        return len;
    }
}