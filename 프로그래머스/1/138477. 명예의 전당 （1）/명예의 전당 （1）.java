import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList();
        List<Integer> hallOfFame = new ArrayList();
        for(int i = 0; i < score.length; i ++) {
            if(hallOfFame.size() < k) {
                hallOfFame.add(score[i]);
                answer.add(Collections.min(hallOfFame));
            } else {
                if(Collections.min(hallOfFame) < score[i]){
                    hallOfFame.remove(hallOfFame.indexOf(Collections.min(hallOfFame)));
                    hallOfFame.add(score[i]);
                    answer.add(Collections.min(hallOfFame));
                } else {
                    answer.add(Collections.min(hallOfFame));
                }

            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}