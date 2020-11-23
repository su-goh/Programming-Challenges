class Solution {
    
    List<String> li;
    int n;
    public List<String> generateParenthesis(int n) {
        
        li = new ArrayList<String>();
        this.n = n;
        bt(0,0,"");
        return li;
    }
    
    private void bt(int open, int close, String curr){ 
        if(curr.length() == n*2) {
            li.add(curr);
            return;
        }
        
        if(open < n) {
            bt(open + 1, close, curr + "(");
        }
        
        if(close < open) {
            bt(open, close + 1, curr + ")");
        }
    }
}
