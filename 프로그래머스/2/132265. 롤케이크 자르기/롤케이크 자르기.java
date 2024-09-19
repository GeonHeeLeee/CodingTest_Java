import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> first = new HashMap();
        Map<Integer, Integer> second = new HashMap();
        
        for(int t : topping) {
            first.put(t, first.getOrDefault(t, 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i ++) {
            int top = topping[i];
            
            second.put(top, second.getOrDefault(top, 0) + 1);
            first.put(top, first.get(top) - 1);
            if(first.get(top) == 0) {
                first.remove(top);
            }
            
            if(first.size() == second.size()) {
                answer ++;
            }
        }
        return answer;
    }
}