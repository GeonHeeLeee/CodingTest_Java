import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> numList = new ArrayList();
        for(int i : numbers) {
            numList.add(Integer.toString(i));
        }
        numList.sort((a,b) -> (b+a).compareTo(a+b));
        if(numList.get(0).equals("0")) {
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        for (String i : numList) {
            answer.append(i);
        }

        return answer.toString();
    }
}
