import java.util.*;
class Solution {
    boolean solution(String s) {
        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack();
        stack.push(input[0]);
        for(int i = 1; i < input.length; i ++) {
            if(!stack.isEmpty() && stack.peek() == '(' && input[i] == ')') {
                stack.pop();
            } else {
                stack.push(input[i]);
            }
            
        }
        return stack.isEmpty();
    }
}
