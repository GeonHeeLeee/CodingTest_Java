import java.time.*;
class Solution {
    public String solution(String videoLen, String pos, String opStart, String opEnd, String[] commands) {
        String answer = "";
        
        if(isBefore(pos, opEnd) && isAfter(pos, opStart)) {
            pos = opEnd;
        }
        for(String command : commands) {
            if(command.equals("next")) {
                pos = plusMinutes(pos, 10);
                if(isAfter(pos, videoLen)) {
                    pos = videoLen;
                } else if (isBefore(pos, opEnd) && isAfter(pos, opStart)) {
                    pos = opEnd;
                }
            } else {
                pos = minusMinutes(pos, 10);
                if(isBefore(pos, "00:00")) {
                    pos = "00:00";
                } else if (isBefore(pos, opEnd) && isAfter(pos, opStart)) {
                    pos = opEnd;
                }
            }
        }
        return parseTime(pos.toString());
    }
    public String parseTime(String time) {
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        if(hour.length() == 1) {
            hour = "0" + hour;
        }
        if(minute.length() == 1) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }
    public boolean isBefore(String t1, String t2) {
        int t1Hour = Integer.parseInt(t1.split(":")[0]);
        int t1Minutes = Integer.parseInt(t1.split(":")[1]);
        int t2Hour = Integer.parseInt(t2.split(":")[0]);
        int t2Minutes = Integer.parseInt(t2.split(":")[1]);
        
        if(t1Hour < t2Hour) {
            return true;
        } else if (t1Hour == t2Hour) {
            if(t1Minutes < t2Minutes) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isAfter(String t1, String t2) {
        int t1Hour = Integer.parseInt(t1.split(":")[0]);
        int t1Minutes = Integer.parseInt(t1.split(":")[1]);
        int t2Hour = Integer.parseInt(t2.split(":")[0]);
        int t2Minutes = Integer.parseInt(t2.split(":")[1]);
        
        if(t1Hour < t2Hour) {
            return false;
        } else if (t1Hour == t2Hour) {
            if(t1Minutes < t2Minutes) {
                return false;
            }
        }
        return true;
    }
    
    public String plusMinutes(String t1, int minutes) {
        int t1Hour = Integer.parseInt(t1.split(":")[0]);
        int t1Minutes = Integer.parseInt(t1.split(":")[1]);
        
        t1Hour += minutes / 60;
        t1Minutes += minutes % 60;
        if(t1Minutes >= 60) {
            t1Hour ++;
            t1Minutes = t1Minutes % 60;
        }
        String t1String = Integer.toString(t1Hour);
        String t2String = Integer.toString(t1Minutes);
        if(t1Hour / 10 == 0) {
            t1String = "0"+t1Hour;
        }
        if(t1Minutes / 10 == 0) {
            t2String = "0"+t1Minutes;
        }
        return t1Hour + ":" + t1Minutes;
    }
    public String minusMinutes(String t1, int minutes) {
        int t1Hour = Integer.parseInt(t1.split(":")[0]);
        int t1Minutes = Integer.parseInt(t1.split(":")[1]);
        
        t1Hour -= minutes / 60;
        t1Minutes -= minutes % 60;
        String t1String = Integer.toString(t1Hour);
        String t2String = Integer.toString(t1Minutes);
        if(t1Minutes < 0) {
            t1Hour --;
            t1Minutes = 60 + t1Minutes;
        }
        if(t1Hour < 0) {
            return "00:00";
        }
        if(t1Hour / 10 == 0) {
            t1String = "0"+t1Hour;
        }
        if(t1Minutes / 10 == 0) {
            t2String = "0"+t1Minutes;
        }
        
        return t1Hour + ":" + t1Minutes;
    }
}