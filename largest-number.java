class Solution {
    public String largestNumber(int[] nums) {
        
        String[] strNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strNums[i] = nums[i] + "";
        }
        
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        
        Arrays.sort(strNums, comp);
        if(strNums[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(String num: strNums) {
            // System.out.println(num);
            sb.append(num);
        }
               
        return sb.toString();
    }
}
