import java.util.*;
import java.util.stream.Collectors; 
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        answer.remove(answer.indexOf(Collections.min(answer)));
        if(answer.size() == 0) {
            return new int[]{-1};
        } else {
            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}