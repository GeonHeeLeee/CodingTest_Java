import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int m, int[] s) {
        int answer = 0;
        List<Integer> score = Arrays.stream(s).boxed().collect(Collectors.toList());
        Collections.sort(score, Collections.reverseOrder());

        for(int i = m-1; i < score.size(); i += m) {
            answer += (score.get(i) * m);
        }
        
        return answer;
    }
}