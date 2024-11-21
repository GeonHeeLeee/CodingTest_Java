import java.util.*;
class Solution {
    public String solution(String p) {
        return splitString(p);
    }
    
    public String splitString(String s) {
        if(s.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i = 1; i <= s.length(); i ++) {
            String u = sb.substring(0, i);
            String v = sb.substring(i, s.length());
            if(isBalanced(u)) {
                if(isCorrect(u)) {
                    return u + splitString(v);
                } else {
                    String emptyStr = "(" + splitString(v) + ")";
                    StringBuilder uResult = new StringBuilder(u.substring(1, u.length()-1));
                    StringBuilder emptyStrSb = new StringBuilder();
                    for(char ch : uResult.toString().toCharArray()) {
                        if(ch == '(') {
                            emptyStrSb.append(")");
                        } else {
                            emptyStrSb.append("(");
                        }
                    }
                    return emptyStr + emptyStrSb.toString();
                }
            }
        }
        return "";
    }
    
    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack();
        char[] ch = s.toCharArray();
        int idx = 0;
        while(idx < ch.length) {
            char peekCh = ' ';
            if(!stack.isEmpty()) {
                peekCh = stack.peek();
            }
            if(peekCh == '(' && ch[idx] == ')') {
                idx ++;
                stack.pop();
                continue;
            }
            stack.add(ch[idx]);
            idx ++;
        }
        return stack.isEmpty() && !s.isEmpty();
    }
    
    public boolean isBalanced(String s) {
        char[] ch = s.toCharArray();
        int leftCount = 0;
        int rightCount = 0;
        for(char letter : ch) {
            if(letter == '(') {
                leftCount ++;
            } else {
                rightCount ++;
            }
        }
        return leftCount == rightCount;
    }
}