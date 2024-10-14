class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        boolean gcdAResult = true;
        boolean gcdBResult = true;
        for(int i = 1; i < arrayA.length; i ++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        for(int i = 0; i < arrayA.length; i ++) {
            if(arrayA[i] % gcdB == 0) {
                gcdBResult = false;
            }
            if(arrayB[i] % gcdA == 0) {
                gcdAResult = false;
            }
        }
        if(gcdAResult && gcdBResult) {
            return Math.max(gcdA, gcdB);
        }
        if(gcdAResult && gcdA != 1) {
            return gcdA;
        } else if(gcdBResult && gcdB != 1) {
            return gcdB;
        }
        return 0;
    }
    
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}