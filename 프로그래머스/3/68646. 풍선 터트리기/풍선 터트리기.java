class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++) {
            minValue = Math.min(minValue, a[i]);
            leftMin[i] = minValue;
        }
        
        minValue = Integer.MAX_VALUE;
        for(int i = n- 1; i > 0; i --) {
            minValue = Math.min(minValue, a[i]);
            rightMin[i] = minValue;
        }
        
        for(int i = 0; i < n; i ++) {
            if(a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer ++;
            }
        }
        return answer;
    }
}