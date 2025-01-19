import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] input = s.toCharArray();
        Arrays.sort(input);
        StringBuilder sb = new StringBuilder(new String(input));
        
        return sb.reverse().toString();
    }
}