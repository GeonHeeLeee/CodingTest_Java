import java.time.*;
class Solution {
    
    private static final String MID_NIGHT = "00:00";
    
    public String solution(String videoLen, String pos, String opStart, String opEnd, String[] commands) {
        if(isOpening(pos, opStart, opEnd)) {
            pos = opEnd;
        }
        
        for(String command : commands) {
            if(command.equals("next")) {
                pos = plusMinutes(pos, 10);
                if(isAfter(pos, videoLen)) {
                    pos = videoLen;
                }
            } else {
                pos = minusMinutes(pos, 10);
                if(isBefore(pos, MID_NIGHT)) {
                    pos = MID_NIGHT;
                }
            }
            if(isOpening(pos, opStart, opEnd)) {
                pos = opEnd;
            }
        }
        return pos.toString();
    }
    public boolean isOpening(String pos, String opStart, String opEnd) {
        return isBefore(pos, opEnd) && isAfter(pos,opStart);
    }
    public boolean isBefore(String t1, String t2) {
        int t1Hour = Integer.parseInt(t1.split(":")[0]);
        int t1Minutes = Integer.parseInt(t1.split(":")[1]);
        int t2Hour = Integer.parseInt(t2.split(":")[0]);
        int t2Minutes = Integer.parseInt(t2.split(":")[1]);
        
        if(t1Hour < t2Hour || (t1Hour == t2Hour && t1Minutes < t2Minutes)) {
            return true;
        }
        return false;
    }
    
    public boolean isAfter(String t1, String t2) {
        return !isBefore(t1, t2);
    }
    
    public String plusMinutes(String time, int minutes) {
        int timeHour = Integer.parseInt(time.split(":")[0]);
        int timeMinutes = Integer.parseInt(time.split(":")[1]);
        
        timeHour += minutes / 60;
        timeMinutes += minutes % 60;
        if(timeMinutes >= 60) {
            timeHour ++;
            timeMinutes = timeMinutes % 60;
        }
        String hourStr = timeHour / 10 == 0 ? "0" + timeHour : Integer.toString(timeHour);
        String minuteStr = timeMinutes / 10 == 0 ? "0" + timeMinutes : Integer.toString(timeMinutes);

        return hourStr + ":" + minuteStr;
    }
    
    public String minusMinutes(String time, int minutes) {
        int timeHour = Integer.parseInt(time.split(":")[0]);
        int timeMinutes = Integer.parseInt(time.split(":")[1]);
        
        timeHour -= minutes / 60;
        timeMinutes -= minutes % 60;

        if(timeMinutes < 0) {
            timeHour --;
            timeMinutes = 60 + timeMinutes;
        }
        if(timeHour < 0) {
            return MID_NIGHT;
        }
        
        String hourStr = timeHour / 10 == 0 ? "0" + timeHour : Integer.toString(timeHour);
        String minuteStr = timeMinutes / 10 == 0 ? "0" + timeMinutes : Integer.toString(timeMinutes);

        return hourStr + ":" + minuteStr;
    }
}