class Solution {
    public boolean halvesAreAlike(String s) {
        int num = 0;
        
        for(int i = 0; i < s.length()/2; i++) {
            Character curr = Character.toLowerCase(s.charAt(i));
            if(!(curr.equals('a') || curr.equals('e') || curr.equals('i') || curr.equals('o') || curr.equals('u'))) continue;
            num++;
        }
                
        for(int i = s.length()/2; i < s.length(); i++){
            Character curr = Character.toLowerCase(s.charAt(i));
            if(!(curr.equals('a') || curr.equals('e') || curr.equals('i') || curr.equals('o') || curr.equals('u'))) continue;
            num--;
        }
                
        return (num == 0) ? true : false;
    }
}
