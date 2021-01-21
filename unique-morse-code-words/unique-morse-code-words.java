class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        int num = 0;
        String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words[i].length(); j++){
                sb.append(morse[words[i].charAt(j) - 'a']);
            }
            
            String curr = sb.toString();
            if(!set.contains(curr)) {
                num++;
                set.add(curr);
            }
        }
        
        return num;
    }
}
