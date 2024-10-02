import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> intSet = new HashSet(); 
        String[] input = numbers.split("");
        for(int i = 0; i < numbers.length(); i ++) {
            dfs(input, intSet, new boolean[numbers.length()], new StringBuilder(), i+1);
        }
        return intSet.size();
    }
    public void dfs(String[] input, Set<Integer> intSet, boolean[] visited, StringBuilder sb, int length) {
        if (sb.length() > 0 && sb.length() <= length && isPrime(Integer.parseInt(sb.toString()))) {
            intSet.add(Integer.parseInt(sb.toString()));
        }
        if (sb.length() == length) {
            return;
        }
        for(int i = 0; i < input.length; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(input[i]);
                dfs(input, intSet, visited, sb, length);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i ++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}