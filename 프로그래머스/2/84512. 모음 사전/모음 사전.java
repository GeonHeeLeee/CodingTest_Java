class Solution {
    public int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O','U'};
        int[] weights = {781,156,31,6,1};
        int answer = 0;
        for(int i = 0; i < word.length(); i ++) {
            char letter = word.charAt(i);
            for(int k = 0; k < vowels.length; k ++) {
                if(letter == vowels[k]) {
                    answer += (k * weights[i] + 1);
                }
            }
        }
        return answer;
    }
}