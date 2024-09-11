import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Character> queue = new LinkedList();
        List<Integer> priority = new ArrayList();
        for(int i = 0; i < priorities.length; i ++) {
            queue.offer((char)('a'+i));
            priority.add(priorities[i]);
        }
        char target = (char)('a'+location);
        while(!queue.isEmpty()) {
            int max = Collections.max(priority);
            char letter = queue.poll();
            int p = priority.remove(0);
            if(p < max) {
                queue.offer(letter);
                priority.add(p);
            } else {
                answer ++;
                if(letter == target) {
                    return answer;
                }
            }
        }
        return answer;
    }
}