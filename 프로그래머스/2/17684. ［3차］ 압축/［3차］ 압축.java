import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dict = new ArrayList<>();
        
        // A~Z 사전 초기화
        for (int i = 0; i < 26; i++) {
            dict.add(Character.toString('A' + i));
        }

        String concatLetter = "";
        String[] input = msg.split("");
        
        for (int i = 0; i < input.length; i++) {
            concatLetter = "";
            for (int k = i; k < input.length; k++) {
                concatLetter += input[k];

                if (!dict.contains(concatLetter)) {
                    answer.add(dict.indexOf(concatLetter.substring(0, concatLetter.length() - 1)) + 1);
                    dict.add(concatLetter);
                    i = k - 1;
                    break;
                }
                
                if (k == input.length - 1) {
                    answer.add(dict.indexOf(concatLetter) + 1);  // 마지막 단어의 인덱스를 추가
                    i = k;
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
