import java.util.*;
class Solution {
    public int solution(int N, int[][] r, int K) {
        int answer = 0;
        Map<Integer, List<int[]>> graph = new HashMap();
        for(int[] road : r) {
            int node = road[0];
            int dest = road[1];
            int weight = road[2];
            graph.computeIfAbsent(road[0], key -> new ArrayList()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1], key -> new ArrayList()).add(new int[]{road[0], road[2]});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{1,0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curNode = current[0];
            int curWeight = current[1];
            
            if(curWeight > dist[curNode]) {
                continue;
            }
            
            for(int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextWeight = next[1];
                
                if(dist[curNode] + nextWeight < dist[nextNode]) {
                    dist[nextNode] = dist[curNode] + nextWeight;
                    queue.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        for(int distance : dist) {
            if(distance <= K)
                answer ++;
        }
        return answer;
    }
}