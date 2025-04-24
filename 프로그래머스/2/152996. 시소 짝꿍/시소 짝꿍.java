import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        TreeMap<Integer, Integer> weightMap = new TreeMap<>();
        
        for(int weight : weights) {
            weightMap.put(weight, weightMap.getOrDefault(weight, 0) + 1);
        }
        
        for(int key : weightMap.keySet()) {
            int count = weightMap.get(key);
            if(count > 1) {
                answer += (long) count * (count - 1) / 2;
            }
        }
        
        int[][] ratios = new int[][]{{1,2}, {2,3}, {3,4}};
        for(int weight : weightMap.keySet()) {
            for(int[] ratio : ratios) {
                int x = ratio[0];
                int y = ratio[1];
                
                if((weight * x) % y != 0) {
                    continue;
                }
                
                int target = (weight * x) / y;
                if(target == weight) {
                    continue;
                }
                if(weightMap.containsKey(target)) {
                    answer += (long) weightMap.get(weight) * weightMap.get(target);
                }
            }
        }
        return answer;
    }
}