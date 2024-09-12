class Solution {
    public int solution(int[] numbers, int target) {
        return backTrack(numbers, target, 0, 0);
    }
    public int backTrack(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        int add = backTrack(numbers, target, index + 1, sum + numbers[index]);
        int subtract = backTrack(numbers, target, index + 1, sum - numbers[index]);
        
        return add + subtract;
    }
}