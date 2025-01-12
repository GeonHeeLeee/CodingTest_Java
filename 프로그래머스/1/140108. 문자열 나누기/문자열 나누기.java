import java.util.*;
class Solution {
    public int solution(String s) {
        char[] input = s.toCharArray();
        int same = 1;
        int diff = 0;
        char x = input[0];
        List<String> answer = new ArrayList();
        String word = Character.toString(x);
        for(int i = 1; i < s.length(); i ++) {
            if(word.equals("")) {
                x = input[i];
            }
            if(x == input[i]) {
                same ++;
            } else {
                diff ++;
            }
            word += Character.toString(input[i]);
            if(same == diff) {
                answer.add(word);
                word = "";
                same = 0;
                diff = 0;
            }

        }
        if(word != "") {
            answer.add(word);
        }
        return answer.size();
    }
}