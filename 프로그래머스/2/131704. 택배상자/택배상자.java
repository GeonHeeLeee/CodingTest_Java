import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        int idx = 0;
        int startIdx = 1;
        int endIdx = order.length;
        for(int i = 0; i < order.length; i ++) {
            while(startIdx <= order[i]) {
                stack.add(startIdx++);
            }
            if(!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer ++;
            } else {
                break;
            }
        }
        return answer;
    }
}