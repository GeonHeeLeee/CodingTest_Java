class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = 200000000;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    public boolean canCross(int[] stones, int k, int people) {
        int count = 0;
        for(int stone : stones) {
            if(stone - people < 0) {
                count ++;
                if(count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }
}