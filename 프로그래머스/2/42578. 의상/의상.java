import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> clothMap = new HashMap();
        for(String[] cloth : clothes) {
            String category = cloth[1];
            String name = cloth[0];
            clothMap.computeIfAbsent(category, k -> new ArrayList()).add(name);
        }
        for(String key : clothMap.keySet()) {
            int size = clothMap.get(key).size();
            answer *= (size+1);
        }
        return answer-1;
    }
}