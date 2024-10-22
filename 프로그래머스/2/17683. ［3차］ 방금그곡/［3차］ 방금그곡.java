import java.util.*;
import java.time.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String[] notes = new String[]{"C#","D#","F#","G#","A#","B#","B","C","D","E","F","G","A"};
        Map<String, Character> noteMap = new HashMap();
        
        int duration = Integer.MIN_VALUE;
        int index = Integer.MAX_VALUE;
        
        for(int i = 0; i < notes.length; i ++) {
            noteMap.put(notes[i], (char) ('a'+i));
            for (int j = 0; j < musicinfos.length; j++) {
                String[] musicInfoArray = musicinfos[j].split(",");
                musicInfoArray[3] = musicInfoArray[3].replaceAll(notes[i], noteMap.get(notes[i]).toString());
                musicinfos[j] = String.join(",", musicInfoArray);
                m = m.replaceAll(notes[i], noteMap.get(notes[i]).toString());
            }
        }
        
        for(int i = 0; i < musicinfos.length; i ++) {
            String[] splitString = musicinfos[i].split(",");
            StringBuilder sb = new StringBuilder();
            LocalTime start = LocalTime.parse(splitString[0]);
            LocalTime end = LocalTime.parse(splitString[1]);
            int minute = (int) Duration.between(start, end).toMinutes();

            for(int j = 0; j < minute; j ++) {
                sb.append(splitString[3].charAt(j % splitString[3].length()));
            }

            if(sb.toString().contains(m)) {
                if(minute > duration) {
                    answer = splitString[2];
                    duration = minute;
                    index = i;
                } else if(minute == duration) {
                    if(i < index) {
                        answer = splitString[2];
                        duration = minute;
                        index = i;
                    }
                }
            }
        }

        
        return answer.equals("") ? "(None)" : answer;
    }
    
}