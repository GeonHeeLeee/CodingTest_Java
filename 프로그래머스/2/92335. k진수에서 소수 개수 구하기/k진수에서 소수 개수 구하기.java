class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] input = Long.toString(n, k).split("0");
        for(String i : input) {
            try {
                if(isPrime(Long.parseLong(i))) {
                    answer ++;
                }
            } catch(Exception e) {
                continue;
            }
            
            
        }
        return answer;
    }
    
    public boolean isPrime(Long input) {
        if(input < 2) {
            return false;
        }
        for(long i = 2; i <=  Math.sqrt(input); i ++) {
            if(input % i == 0) {
                return false;
            }
        }
        return true;
    }
}