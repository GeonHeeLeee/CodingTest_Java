import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothMap = new HashMap();
        for(String[] cloth : clothes) {
            String name = cloth[0];
            String parts = cloth[1];
            clothMap.put(parts, clothMap.getOrDefault(parts, 0) + 1);
        }
        
        for(String key : clothMap.keySet()) {
            answer *= (clothMap.get(key) + 1);
        }
        
        return answer - 1;
    }
}