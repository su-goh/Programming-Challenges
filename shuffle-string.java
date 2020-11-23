class Solution {
    public String restoreString(String s, int[] indices) {
        int len = indices.length;
        String[] str = new String[len];
        String s2 = "";
        
        for(int i = 0; i < len; i++) {
            int j = indices[i];
            str[j] = s.substring(i,i+1);
        }
        
        int i = 0;
        while (i != len) {
            s2 = s2.concat(str[i++]);
        }
        
        return s2;
        
    }
}
