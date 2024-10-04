class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int count = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder(number);
        while(count < k && index < sb.length() - 1) {
            if(sb.charAt(index) < sb.charAt(index+1)) {
                sb.deleteCharAt(index);
                count ++;
                if(index > 0) {
                    index --;
                }
            } else {
                index ++;
            }
        }
        
        while(count < k) {
            sb.deleteCharAt(sb.length() - 1);
            count ++;
        }
        
        return sb.toString();
    }
}