import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack();
        char[] input = s.toCharArray();
        stack.add(input[0]);
        for(int i = 1; i < input.length; i ++) {
            if(!stack.isEmpty() && stack.peek() == input[i]) {
                stack.pop();
            } else {
                stack.add(input[i]);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}