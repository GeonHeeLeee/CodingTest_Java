import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int removed = 0;
        char[] input = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < input.length; i ++) {
            char current = input[i];
            while(!stack.isEmpty() && stack.peek() < current && removed < k) {
                stack.pop();
                removed ++;
            }
            stack.add(current);
        }
        
        int remain = (k - removed);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().substring(0, sb.length() - remain).toString();
    }
}