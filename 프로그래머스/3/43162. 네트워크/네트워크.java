import java.util.*;
class Solution {
    Map<Integer, Queue<Integer>> graph = new HashMap();
    int answer = 0;
    public int solution(int n, int[][] computers) {
        for(int row = 0; row < n; row ++) {
            for(int col = 0; col < n; col ++) {
                Queue<Integer> queue = graph.computeIfAbsent(row, key -> new LinkedList());
                if(computers[row][col] == 1 && col != row) {
                   queue.offer(col); 
                }
            }
        }
        graph.keySet().stream().filter(key -> graph.get(key).isEmpty())
            .forEach(a -> answer ++);
        for(int node = 0; node < n; node ++) {
            if(!graph.get(node).isEmpty()) {
                dfs(node);
                answer ++;
            }
        }
        return answer;
    }
    public void dfs(int node) {
        while(graph.containsKey(node) && !graph.get(node).isEmpty()) {
            int next = graph.get(node).poll();
            dfs(next);
        }
    }
}