class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(target, numbers, 0, 0);
        return answer;
    }
    public void dfs(int target, int[] numbers, int index, int sum) {
        if(index == numbers.length) {
            if(target == sum) {
                answer ++;
            }
            return;
        }
        
        dfs(target, numbers, index + 1, sum + numbers[index]); 
        dfs(target, numbers, index + 1, sum - numbers[index]); 
    }
}