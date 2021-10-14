class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        int numDelete = 0;
        HashSet<Integer> dp = new HashSet<>();
        for(Character c : freq.keySet()) {
            int currFreq = freq.get(c);
            while(dp.contains(currFreq)) {
                numDelete++;
                currFreq--;
            }
            if(currFreq > 0) dp.add(currFreq);
        }
        
        return numDelete;
    }
}