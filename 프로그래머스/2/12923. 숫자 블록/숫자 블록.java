class Solution {
    public int[] solution(long begin, long end) {
        
        int[] answer = new int[(int) (end - begin + 1)];
        
        
        for(long idx = begin; idx <= end; idx ++) {
            if(idx == 1) {
                answer[(int) (idx - begin)] = 0;
                continue;
            }
            fillNumber(answer, idx, begin);
        }
        return answer;
    }
    
    public void fillNumber(int[] answer, long idx, long begin) {
        int result = 1;
        for(long i = 2; i <= Math.sqrt(idx) + 1; i ++) {
            if(idx % i == 0) {
                long pair = idx / i;
                
                if(pair <= 10000000) {
                    answer[(int) (idx - begin)] = (int) pair; 
                    return;
                }
                
                if(i <= 10000000) {
                    result = (int)i;
                }
                
            }
        }
        answer[(int) (idx - begin)] = result;
        return;
    }
}