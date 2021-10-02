class Solution {
    ArrayList<String> validStrings;
    
    public List<String> removeInvalidParentheses(String s) {
        validStrings = new ArrayList<>();
        
        recurse(s, 0, 0, new int[]{'(', ')'});
        
        return validStrings;
    }
    
    private void recurse(String s, int lastVisit, int lastRemove, int[] brackets) {
        int counter = 0;
        for(int i = lastVisit; i < s.length(); i++) {
            if(s.charAt(i) == brackets[0]) counter++;
            else if(s.charAt(i) == brackets[1]) counter--;
            if(counter >= 0) continue; // string is valid to this point
            
            // an extra ')' detected, remove all ')' since the lastRemoved )
            for(int j = lastRemove; j <= i; j++) {
                if(s.charAt(j) == brackets[1] && (j == lastRemove || s.charAt(j - 1) != brackets[1])) {
                    recurse(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, brackets);
                }
            }
            return;
        }
        
        // remove all possible ')' that needs to be considered, consider extra '('
        String reverse = (new StringBuilder(s)).reverse().toString();
        if(brackets[0] == ')') validStrings.add(reverse);
        else recurse(reverse, 0, 0, new int[]{')', '('});
    }
}