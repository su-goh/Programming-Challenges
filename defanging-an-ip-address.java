class Solution {
    public String defangIPaddr(String address) {
        
        String st = "";
        StringBuilder s = new StringBuilder();
        char[] c = address.toCharArray();
        
        for(int i = 0; i < c.length; i++) {
            st = st.concat(c[i] == '.' ?  ("[.]") : (String.valueOf(c[i])));
        }
​
        return st; //.toString();
    }
    
    
}
