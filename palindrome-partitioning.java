class Solution {
    public List<List<String>> partition(String s) {
        if(s.length() == 0 || s == null) return new ArrayList<>();
        
        List<List<String>> ret = new ArrayList<>();
        
        helper(s, ret, new ArrayList<>());
        
        return ret;
    }
    
    public void helper(String s, List<List<String>> ret, List<String> currList) {
        // base case
        if(s.length() == 0) {
            ret.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i = 0; i < s.length(); i++) {
            String temp = s.substring(0,i+1);
            if(!isPalindrone(temp)) continue;
            
            currList.add(temp);
            helper(s.substring(i+1,s.length()), ret, currList);
            currList.remove(currList.size() - 1);
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
