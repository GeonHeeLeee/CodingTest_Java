class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        char[] input = String.valueOf(x).toCharArray();
        int sum = 0;
        for(char a : input) {
            sum += a -'0';
        }
        return x % sum == 0;
    }
}