class Solution {
    public String solution(int n, int t, int m, int p) {
        String number = "";
        String answer = "";
        for(int i = 0; i <= t*m; i ++) {
            number += Integer.toString(i, n);
        }
        number = number.toUpperCase();
        String[] input = number.split("");
        for(int i = p - 1; i < t*m; i += m) {
            answer += input[i];
        }
        return answer;
    }
}