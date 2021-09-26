class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> dp = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        
        for(int i = 0; i < s.length(); i++) dp.add(new ArrayList<String>());
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                String currString = s.substring(j, i+1);
                if(dict.contains(currString) && (j == 0 || dp.get(j - 1).size() > 0)) {
                    List<String> currWords = (j == 0) ? new ArrayList<String>() : dp.get(j - 1);
                    List<String> build = dp.get(i);
                    for(int k = 0; k < currWords.size(); k++) {
                        build.add(currWords.get(k) + " " + currString);
                    }
                    if(currWords.size() == 0) build.add(currString);
                }
            }
        }
        
        return dp.get(s.length() - 1);
    }
}