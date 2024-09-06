import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> tangerineMap = new HashMap();
        for(int i = 0; i < tangerine.length; i ++) {
            tangerineMap.put(tangerine[i], tangerineMap.getOrDefault(tangerine[i], 0) + 1);
        }
        List<Integer> countMap = new ArrayList(tangerineMap.values());
        Collections.sort(countMap, Collections.reverseOrder());

        for(int weight : countMap) {
            if(k > 0) {
                k -= weight;
                answer ++;
            }
        }
        return answer;
    }
}