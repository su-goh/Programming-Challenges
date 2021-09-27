class Solution {
    public double angleClock(int hour, int minutes) {
        double angle = 0;
        double hourAngle = 0;
        double minuteAngle = 0;
        
        if(hour == 12) hour = 0;
        
        hourAngle = hour*30.0 + (minutes/60.0)*30.0;
        minuteAngle = minutes*6.0;
        angle = Math.max(hourAngle, minuteAngle) - Math.min(hourAngle, minuteAngle);
        
        return angle > 180 ? 360.0 - angle : angle;
    }
}