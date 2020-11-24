class Solution {
    public String largestNumber(int[] nums) {
        
        String[] strNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        
        Arrays.sort(strNums, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        if(strNums[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < strNums.length; i++) {
            sb.append(strNums[i]);
        }
               
        return sb.toString();
    }
}
