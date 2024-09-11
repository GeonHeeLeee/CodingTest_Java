import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList();
        List<Integer> time = new ArrayList();
        Deque<Integer> deque = new ArrayDeque();
        for(int i = 0; i < progresses.length; i ++) {
            if((100 - progresses[i]) % speeds[i] != 0) {
                time.add((100-progresses[i]) / speeds[i] + 1);
            } else {
                time.add((100-progresses[i]) / speeds[i]);
            }
        }

        int end = 0;
        int count = 1;
        deque.addLast(time.get(0));
        end = time.get(0);
        for(int i = 1; i < time.size(); i ++) {
            if(end < time.get(i)) {
                answer.add(count);
                count = 1;
                deque.clear();
                end = time.get(i);
                deque.addLast(time.get(i));
            } else {
                deque.addLast(time.get(i));
                count ++;
            }
            if(i == time.size() -1) {
                answer.add(count);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}