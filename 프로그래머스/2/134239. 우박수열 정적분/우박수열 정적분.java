import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Double> hailList = hailSequence((double) k);
        for(int i = 0; i < ranges.length; i ++) {
            int startX = ranges[i][0];
            int endX = ranges[i][1];
            int n = hailList.size();
            if(startX > n-1 || startX >= n + endX) {
                answer[i] = -1;
                continue;
            }
            double integral = 0;
            for(int x = startX; x < hailList.size() + endX - 1; x ++) {
                double y1 = hailList.get(x);
                double y2 = hailList.get(x+1);
                integral += ((y1 + y2) / 2);
            }
            answer[i] = integral;
        }
        return answer;
    }
    
    public List<Double> hailSequence(double k) {
        List<Double> hailList = new ArrayList();
        hailList.add(k);
        while(k > 1) {
            if(k % 2 == 0) {
                k = k / 2;
            } else {
                k = (k * 3) + 1;
            }
            hailList.add(k);
        }
        return hailList;
    }
}