class Solution {
    public boolean halvesAreAlike(String s) {
        int num = 0;
        String vowels = "AEIOUaeiou";
        
        for(int i = 0; i < s.length()/2; i++) {
            if(vowels.indexOf(s.charAt(i)) == -1) continue;
            num++;
        }
                
        for(int i = s.length()/2; i < s.length(); i++){
            if(vowels.indexOf(s.charAt(i)) == -1) continue;
            num--;
        }
                
        return (num == 0) ? true : false;
    }
}
