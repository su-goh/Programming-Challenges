class Solution {
    HashSet<String> validStrings = new HashSet<>();
    
    public List<String> removeInvalidParentheses(String s) {
        validStrings = new HashSet<>();
        int numLeftToRemove = 0, numRightToRemove = 0;
        
        // pre process, compute numLeftToRemove and numRightToRemove
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            
            if(currChar == '(') numLeftToRemove++;
            else if(currChar == ')') {
                if(numLeftToRemove <= 0) numRightToRemove++;
                else numLeftToRemove--;
            }
        }
                
        // dfs to find validStrings
        recurse(0, 0, 0, new StringBuilder(), s, numLeftToRemove, numRightToRemove);
        
        return new ArrayList<String>(validStrings);
    }
    
    private void recurse(int leftCount, int rightCount, int i, StringBuilder sb, String s, int numLeftToRemove, int numRightToRemove) {
        if(i == s.length()) {
            if(leftCount == rightCount && numLeftToRemove == 0 && numRightToRemove == 0) validStrings.add(sb.toString());
            return;
        }

        char currChar = s.charAt(i);
                
        // discard current
        if(currChar == '(' && numLeftToRemove > 0 && numRightToRemove >= 0) {
            recurse(leftCount, rightCount, i + 1, sb, s, numLeftToRemove - 1, numRightToRemove);
        } else if(currChar == ')' && numRightToRemove > 0 && numLeftToRemove >= 0) {
            recurse(leftCount, rightCount, i + 1, sb, s, numLeftToRemove, numRightToRemove - 1);
        }
        
        // keep
        sb.append(currChar);
        if(currChar == '(') recurse(leftCount + 1, rightCount, i + 1, sb, s, numLeftToRemove, numRightToRemove);
        else if(currChar == ')' && rightCount < leftCount) recurse(leftCount, rightCount + 1, i + 1, sb, s, numLeftToRemove, numRightToRemove);
        else recurse(leftCount, rightCount, i + 1, sb, s, numLeftToRemove, numRightToRemove);
        
        sb.deleteCharAt(sb.length() - 1);
    }
}