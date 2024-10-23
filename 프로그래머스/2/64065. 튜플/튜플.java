import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] input = s.split("\\},\\{");
        List<Integer> seenNum = new ArrayList();
        int[] answer = new int[input.length];
        for(int i = 0; i < input.length; i ++) {
            input[i] = input[i].replaceAll("\\{", "").replaceAll("\\}","");
        }
        Arrays.sort(input, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        for(int i = 0; i < input.length; i ++) {
            String[] numbers = input[i].split(",");
            for(int j = 0; j < numbers.length; j ++) {
                if(!seenNum.contains(Integer.parseInt(numbers[j])) && !numbers[j].isEmpty()) {
                    answer[i] = Integer.parseInt(numbers[j]);
                    seenNum.add(Integer.parseInt(numbers[j]));
                    break;
                }
            }
        }
        return answer;
    }
}