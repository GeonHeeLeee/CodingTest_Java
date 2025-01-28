import java.util.*;
import java.util.Collections;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> answer = new TreeSet();
        backTrack(0,0,0,numbers,answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
    public void backTrack(int index, int sum, int count, int[] numbers, Set<Integer> answer) {
        if(count == 2) {
            answer.add(sum);
            return;
        }
        if(index >= numbers.length) {
            return;
        }
        backTrack(index + 1, sum + numbers[index], count + 1, numbers, answer);
        backTrack(index + 1, sum, count, numbers, answer);
        
        return;
    }
}