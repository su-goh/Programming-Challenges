class Solution {
    public int[] plusOne(int[] digits) {
        int leading = 1;
        
        for(int i = digits.length - 1; i >= 0; i--) {
            if(leading == 0) return digits;
            else if(digits[i] == 9 && leading == 1)
                digits[i] = 0;
            else if(digits[i] < 9 && leading == 1) {
                digits[i] += 1;
                leading = 0;
            }
        }
        
        int[] newArray = new int[digits.length + 1];
        if(digits[0] == 0) {
            newArray[0] = 1;
            for(int i = 0; i < digits.length; i++) newArray[i+1] = digits[i];
            return newArray;
        }
        
        return digits;
    }
}
