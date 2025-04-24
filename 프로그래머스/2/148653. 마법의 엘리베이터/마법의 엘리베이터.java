class Solution {
    public int solution(int storey) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(String.valueOf(storey));
        
        for(int i = sb.length() - 1; i >= 0; i --) {
            int current = sb.charAt(i) - '0';
            if(i == 0) {
                answer += Math.min(10 - current + 1, current);
                break;
            }
            int before = sb.charAt(i - 1) -'0';
            
            if(current > 5) {
                answer += (10 - current);
                sb.setCharAt(i - 1,  (char) (before + 1 +'0'));
            } else if(current == 5) {
                if(before >= 5) {
                    answer += (10 - current);
                    sb.setCharAt(i - 1, (char) (before + 1 +'0'));
                } else {
                    answer += current;
                }
            } else {
                answer += current;
            }
        }
        return answer;
    }
}