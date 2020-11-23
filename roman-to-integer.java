class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        
        // create a table to reference 
        HashMap<Character, Integer> table = new HashMap<>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        
        //char[] arr = s.toCharArray();
        int prev = table.get(s.charAt(s.length() - 1));
        int tot = 0;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            int curr = table.get(s.charAt(i));
            tot += (prev > curr) ? -curr : curr;
            prev = curr;
        }
        
        return tot;
    }
}
