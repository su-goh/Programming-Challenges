class Solution {
    List<String> ret;
    Set<String> retSet;
    int n;
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<>();
        retSet = new HashSet<>();
        this.n = n;
        
        helper(n, n, new StringBuilder());
        
        return ret;
    }
    
    private void helper(int open, int close, StringBuilder sb) {
        if (close == 0 && !retSet.contains(sb.toString())) {
            ret.add(sb.toString());
            retSet.add(sb.toString());
            return;
        }
                
        if (open > 0) {
            helper(open - 1, close, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (close > open) {
            helper(open, close - 1, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}  