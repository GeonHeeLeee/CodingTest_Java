import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Map<Integer, List<int[]>> graph = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];
        for(int[] cost : costs) {
            int current = cost[0];
            int next = cost[1];
            int weight = cost[2];
            
            graph.computeIfAbsent(current, key -> new ArrayList<>()).add(new int[]{next, weight});
            graph.computeIfAbsent(next, key -> new ArrayList<>()).add(new int[]{current, weight});
        }
        
        pq.addAll(graph.get(0));
        visited[0] = true;
        
        while(!pq.isEmpty()) {
            int[] minNode = pq.poll();
            int next = minNode[0];
            int weight = minNode[1];
            
            if(!visited[next]) {
                answer += weight;
                visited[next] = true;
                pq.addAll(graph.get(next));
            }
        }
        
        return answer;
    }
}