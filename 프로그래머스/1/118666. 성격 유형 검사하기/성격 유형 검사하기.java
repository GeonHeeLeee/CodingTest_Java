import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> choiceMap = new HashMap();
        Map<Character, Integer> resultMap = new HashMap();
        int start = 3;
        for(int i = 1; i < 8; i ++) {
            choiceMap.put(i, Math.abs(start));
            start --;
        }

        for(int i = 0; i < choices.length; i ++) {
            int choice = choices[i];
            if(choice < 4) {
                resultMap.put(survey[i].charAt(0), resultMap.getOrDefault(survey[i].charAt(0),0) + choiceMap.get(choice));
            } else if(choiceMap.get(choice) > 0) {
                resultMap.put(survey[i].charAt(1), resultMap.getOrDefault(survey[i].charAt(1),0) + choiceMap.get(choice));
            }
        }
        appendSB(sb, 'R', 'T', resultMap);
        appendSB(sb, 'C', 'F', resultMap);
        appendSB(sb, 'J', 'M', resultMap);
        appendSB(sb, 'A', 'N', resultMap);
        return sb.toString();
    }
    
    public void appendSB(StringBuilder sb, char a, char b, Map<Character, Integer> resultMap) {
        if(resultMap.getOrDefault(a, 0) >= resultMap.getOrDefault(b, 0)) {
            sb.append(a);
        } else {
            sb.append(b);
        }
    }
}