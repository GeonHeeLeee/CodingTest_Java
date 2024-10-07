class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, Integer.MAX_VALUE};
        int firstIdx = 0;
        int sum = 0;
        for(int lastIdx = 0; lastIdx < sequence.length; lastIdx++) {
            sum += sequence[lastIdx];
            while(sum > k && firstIdx <= lastIdx) {
                sum -= sequence[firstIdx];
                firstIdx ++;
            }
            
            if(sum == k && answer[1]-answer[0] > lastIdx-firstIdx) {
                answer[0] = firstIdx;
                answer[1] = lastIdx;
            }
        }
        return answer;
    }
}