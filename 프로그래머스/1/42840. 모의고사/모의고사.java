import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList();
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int[] one = {1, 2, 3, 4, 5,1, 2, 3, 4, 5,1, 2, 3, 4, 5,1, 2, 3, 4, 5,1, 2, 3, 4, 5,1, 2, 3, 4, 5,1, 2, 3, 4, 5,1, 2, 3, 4, 5};
        int[] two = { 2, 1, 2, 3, 2, 4, 2, 5,  2, 1, 2, 3, 2, 4, 2, 5,  2, 1, 2, 3, 2, 4, 2, 5,  2, 1, 2, 3, 2, 4, 2, 5,  2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};
        for(int i = 0; i < answers.length; i ++) {
            if(one[i % 40] == answers[i]) {
                oneCount ++;
            }
            if(two[i% 40] == answers[i]) {
                twoCount ++;
            }
            if(three[i%40] == answers[i]) {
                threeCount ++;
            }
        }
        int max = Math.max(oneCount, Math.max(twoCount, threeCount));
        if(oneCount == max) {
            answer.add(1);
        }
        if(twoCount == max) {
            answer.add(2);
        }
        if(threeCount == max) {
            answer.add(3);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}