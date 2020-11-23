class Solution {
    public boolean isAnagram(String s, String t) {
        
        // Count array, Faster, no need sort
        int[] count = new int[26];
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();
        
        for(int i = 0; i < a1.length; i++) count[a1[i] - 'a'] += 1;
        for(int i = 0; i < a2.length; i++) count[a2[i] - 'a'] -= 1;
        for(int i = 0; i < 26; i++) if (count[i] != 0 ) return false;  
        return true;
        
        
        /**
        // sort array approach
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        if (a1.length != a2.length) return false;
        
        for(int i = 0; i < a1.length; i++) {
            if(a1[i] != a2[i]) return false;
        }
        
        return true;
        **/
        
    }
}
