class Solution {
    public boolean isRobotBounded(String instructions) {
        int currDirection = 0;
        int upDown = 0;
        int leftRight = 0;
        
        for(int i = 0; i < instructions.length(); i++) {
            char currSymbol = instructions.charAt(i);
            if(currSymbol == 'G') {
                if(currDirection == 0) upDown++;
                else if(currDirection == 1) leftRight++;
                else if(currDirection == 2) upDown--;
                else if(currDirection == 3) leftRight--;
                //System.out.println(upDown + " " + leftRight);
            } else {
                if(currSymbol == 'L') {
                    if(currDirection == 0) currDirection = 3;
                    else currDirection--;
                }
                else if(currSymbol == 'R') {
                    if(currDirection == 3) currDirection = 0;
                    else currDirection++;
                }
            }
        }
        
​
        if(upDown == 0 && leftRight == 0) return true;
        else if (currDirection != 0) {
            return true;
        }
        return false;
    }
}
