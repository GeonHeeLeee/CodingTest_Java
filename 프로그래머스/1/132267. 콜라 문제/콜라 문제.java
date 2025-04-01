class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int coke = n;
        int emptyBottle;
        int remainCoke;
        while(coke >= a) {
            emptyBottle = (coke / a * b);
            remainCoke = coke % a;
            coke = emptyBottle + remainCoke;
            answer += emptyBottle;
        }
        
        return answer;
    }
}