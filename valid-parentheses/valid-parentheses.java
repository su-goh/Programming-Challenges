class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> open = new HashMap<>(){{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        
        for(int i = 0; i < s.length(); i++) {
            if(open.containsKey(s.charAt(i))) st.push(s.charAt(i));
            else if(st.size() == 0 || open.get(st.pop()) != s.charAt(i)) 
                return false;
        }
        
        return st.size() == 0 ? true : false;
    }
}