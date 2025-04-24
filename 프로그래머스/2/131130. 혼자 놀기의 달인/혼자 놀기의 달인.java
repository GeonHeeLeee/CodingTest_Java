import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        int[] boxes = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            boxes[i] = cards[i - 1];
        }
        
        
        for(int i = 1; i <= n; i ++) {
            boolean[] visited = new boolean[n + 1];
            List<Integer> firstGroup = new ArrayList<>();
            List<Integer> secondGroup = new ArrayList<>();
            visited[i] = true;
            firstGroup.add(i);
            dfs(boxes, visited, i, firstGroup);
            
            for(int j = 1; j <= n; j ++) {
                if(!visited[j]) {
                    visited[j] = true;
                    secondGroup.add(j);
                    dfs(boxes, visited, j, secondGroup);
                    answer = Math.max(answer, firstGroup.size() * secondGroup.size());
                }
                for(int num : secondGroup) {
                    visited[num] = false;
                }
                secondGroup.clear();
            }
            
            
            
        }
        return answer;
    }
    
    public void dfs(int[] boxes, boolean[] visited, int current, List<Integer> group) {
        int nextNum = boxes[current];
        if(!visited[nextNum]) {
            visited[nextNum] = true;
            group.add(nextNum);
            dfs(boxes, visited, nextNum, group);
        }
    }
}