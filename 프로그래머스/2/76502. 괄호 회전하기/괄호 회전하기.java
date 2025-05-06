import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> deque = new ArrayDeque();
        //순환
        for(int i = 0; i < s.length(); i ++) {
            for(int j = i; j < s.length() + i; j ++) {
                deque.addLast(s.charAt(j % s.length()));
            }
            String stack = "";
            for(int k = 0; k < s.length(); k ++) {
                stack += Character.toString(deque.removeFirst());
                if(stack.length() >= 2) {
                    String subStr = stack.substring(stack.length()-2);
                    if(subStr.equals("()") || subStr.equals("{}") || subStr.equals("[]")) {
                        stack = stack.substring(0, stack.length() - 2);
                    }
                }
            }
            
            
            if(stack.length() == 0) {
                answer ++;
            }
            deque.clear();
        }
        return answer;
    }
}