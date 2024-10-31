import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> weightMap = new HashMap();
        for(int weight : weights) {
            weightMap.put(weight, weightMap.getOrDefault(weight, 0) + 1);
        }
        
        for(int weight : weightMap.keySet()) {
            int count = weightMap.get(weight);
            if(count > 1) {
                answer += (long) (count) * (count -1) / 2;
            }
            
            int[] ratios = new int[]{2,3,4};
            for(int ratio : ratios) {
                int targetWeight = weight * (ratio) / (ratio - 1);
                
                if(targetWeight != weight && weightMap.containsKey(targetWeight) && targetWeight * (ratio - 1) == weight * ratio) {
                    answer += (long) count * weightMap.get(targetWeight);
                }
            }
        }
        return answer;
    }
}