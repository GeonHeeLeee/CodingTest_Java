import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothMap = new HashMap();
        for(String[] s : clothes) {
            clothMap.put(s[1], clothMap.getOrDefault(s[1],0)+1);
        }
        for(int count : clothMap.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}