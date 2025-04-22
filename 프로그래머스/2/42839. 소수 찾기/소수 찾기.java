import java.util.*;
class Solution {
    int answer = 0;
    Set<Integer> possibles = new HashSet<>();
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        for(int i = 0 ; i < nums.length; i ++) {
            boolean[] isUsed = new boolean[nums.length];
            isUsed[i] = true;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            if(isPrimeNumber(Integer.parseInt(sb.toString()))) {
                possibles.add(Integer.parseInt(sb.toString()));
            }
            getCombinations(nums, sb, isUsed);
        }
        
        System.out.println(possibles);
        return possibles.size();
    }
    
    public void getCombinations(char[] nums, StringBuilder sb, boolean[] isUsed) {
        for(int i = 0; i < nums.length; i ++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                sb.append(nums[i]);
                if(isPrimeNumber(Integer.parseInt(sb.toString()))) {
                    possibles.add(Integer.parseInt(sb.toString()));
                }
                getCombinations(nums, sb, isUsed);
                sb.deleteCharAt(sb.length() - 1); 
                isUsed[i] = false;
            }

        }
    }
    
    public boolean isPrimeNumber(int number) {
        if(number < 2) {
            return false;
        }
        if(number == 2) {
            return true;
        }
        for(int i = 2; i < number; i ++) {
            if(number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}