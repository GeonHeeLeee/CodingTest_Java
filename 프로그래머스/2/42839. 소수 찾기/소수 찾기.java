import java.util.*;
class Solution {
    Set<Integer> primeSet = new HashSet();
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers.toCharArray(), "", visited);
        System.out.println(primeSet);
        return primeSet.size();
    }
    public void dfs(char[] numbers, String current, boolean[] visited) {
        if(!current.isEmpty()) {
            if(isPrime(Integer.parseInt(current))) {
                primeSet.add(Integer.parseInt(current));
            }
        }
        for(int index = 0; index < numbers.length; index ++) {
            if(!visited[index]) {
                visited[index] = true;
                dfs(numbers, current + numbers[index], visited);
                visited[index] = false;
            }
            
        }
        
    }
    public boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for(int i = 2; i <= sqrt; i ++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}