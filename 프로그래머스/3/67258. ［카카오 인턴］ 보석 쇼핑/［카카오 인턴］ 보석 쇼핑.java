import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int jewelryNum = new HashSet(Arrays.asList(gems)).size();
        Map<String, Integer> jewelryMap = new HashMap();
        int start = 0;
        int length = Integer.MAX_VALUE;
        
        for(int idx = 0; idx < gems.length; idx ++) {
            jewelryMap.put(gems[idx], jewelryMap.getOrDefault(gems[idx], 0) + 1);
            
            while(jewelryMap.get(gems[start]) > 1) {
                jewelryMap.put(gems[start], jewelryMap.get(gems[start]) - 1);
                start ++;
            }
            
            if(jewelryMap.size() == jewelryNum && length > (idx - start)) {
                length = idx - start;
                answer[0] = start + 1;
                answer[1] = idx + 1;
            }
        }
        return answer;
    }
}