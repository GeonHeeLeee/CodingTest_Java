import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> input = Arrays.stream(cities).map(String::toLowerCase).collect(Collectors.toList());
        Deque<String> cache = new ArrayDeque();
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        for(String city : input) {
            if(!cache.contains(city)) {
                if(cache.size() >= cacheSize) {
                    cache.removeFirst();
                }
                answer += 5;
            } else {
                cache.remove(city);
                answer += 1;
            }
            cache.addLast(city);
        }
        return answer;
    }
}