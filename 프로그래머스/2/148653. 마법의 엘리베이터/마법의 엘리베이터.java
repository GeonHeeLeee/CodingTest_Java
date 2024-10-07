import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(Integer.toString(storey));
        for(int i = sb.length() - 1; i >= 0; i --) {
            int num = sb.charAt(i) - '0';
            if(i == 0) {
                if(num > 5) {
                    answer += (10 - num);
                    answer ++;
                } else {
                    answer += num;
                }
                break;
            }
            if(num > 5) {
                answer += (10 - num);
                sb.setCharAt(i-1, (char)(sb.charAt(i-1) + 1)); 
            } else if(num == 5) {
                if(sb.charAt(i-1) >= '5') {
                    answer += (10 - num);
                    sb.setCharAt(i-1, (char)(sb.charAt(i-1) + 1)); 
                } else {
                    System.out.println(true);
                    answer += num;
                }
            } else {
                answer += num;
            }
        }
        return answer;
    }
}
