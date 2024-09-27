import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        List<Long> answer = new ArrayList();
        for(long num : numbers) {
            StringBuilder sb = new StringBuilder(Long.toBinaryString(num));
            if(Long.bitCount(num) == sb.length()) {
                    num = num + (long) Math.pow(2, sb.length()) - (long) Math.pow(2, sb.length() - 1);
                    answer.add(num);
                    continue;
            }
            for(int i = sb.length()-1; i >= 0; i --) {
                if(sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    if(i+1 < sb.length() && sb.charAt(i + 1) == '1') {
                        sb.setCharAt(i+1, '0');
                    }
                    break;
                }
            }
            answer.add(Long.parseLong(sb.toString(), 2));
        }
        return answer.stream().mapToLong(i->i).toArray();
    }
}