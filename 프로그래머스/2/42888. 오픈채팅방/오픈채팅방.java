import java.util.*;
class Solution {
    public String[] solution(String[] records) {
        List<String> answer = new ArrayList();
        Map<String, String> idMap = new HashMap();
        for(String record : records) {
            String[] input = record.split(" ");
            if(!input[0].equals("Leave")) {
                idMap.put(input[1], input[2]);
            }
        }
        for(String record : records) {
            String[] input = record.split(" ");
            switch(input[0]) {
                case "Enter" :
                    answer.add(idMap.get(input[1])+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(idMap.get(input[1])+"님이 나갔습니다.");
                    break;
            }
        }
        return answer.stream().toArray(String[]::new);
    }
}