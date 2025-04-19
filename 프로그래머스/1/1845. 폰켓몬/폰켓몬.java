import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> pokemonMap = new HashMap();
        for(int num : nums) {
            pokemonMap.put(num, pokemonMap.getOrDefault(num, 0) + 1);
        }
        
        int n = nums.length / 2;
        int pokemonCount = pokemonMap.keySet().size();
        if(n < pokemonCount) {
            return n;
        } else {
            return pokemonCount;
        }
    }
}