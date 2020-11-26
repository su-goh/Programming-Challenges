class Solution {
    public List<List<String>> partition(String s) {
        if(s.length() == 0 || s == null) return new ArrayList<>();
        
        List<List<String>> ret = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        helper(0, s, ret, new ArrayList<>(), dp);
        return ret;
    }
    
    public void helper(int start, String s, List<List<String>> ret, List<String> currList, boolean[][] dp) {
        // base case
        if(s.length() - start == 0) {
            ret.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            // String temp = s.substring(start,i+1);
            // if(!isPalindrone(temp)) continue;
            if(s.charAt(start) == s.charAt(i) && (i-start <=2 || dp[start+1][i-1])) {
                dp[start][i] = true;
                currList.add(s.substring(start, i+1));
                helper(i+1, s, ret, currList, dp);
                currList.remove(currList.size() - 1);
            }
        }
        
        return;
    }
    
    public boolean isPalindrone(String s) {
        int p1 = 0, p2 = s.length() - 1;
        while(p1 < p2) {
            if(s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
