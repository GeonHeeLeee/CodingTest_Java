import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> partici = new HashMap();
        String answer = "";
        for(String part : participant) {
            partici.put(part, partici.getOrDefault(part, 0) + 1);
        }

        for(String comp : completion) {
            partici.put(comp, partici.get(comp) - 1);
        }

        for(String res : partici.keySet()) {
            if(partici.get(res) > 0) {
                answer = res;
                break;
            }
        }
        return answer;
    }
}