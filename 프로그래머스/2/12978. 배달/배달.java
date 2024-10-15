import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        Map<Integer, List<int[]>> graph = new HashMap();
        for(int i = 0; i < road.length; i ++) {
            graph.computeIfAbsent(road[i][0], key -> new ArrayList()).add(new int[]{road[i][1], road[i][2]});
            graph.computeIfAbsent(road[i][1], key -> new ArrayList()).add(new int[]{road[i][0], road[i][2]});
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{1, 0});
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];
            
            if(distance > dist[node]) {
                continue;
            }
            
            for(int[] dest : graph.get(node)) {
                int destNode = dest[0];
                int weight = dest[1];
                
                if(dist[node] + weight < dist[destNode]) {
                    dist[destNode] = dist[node] + weight;
                    queue.add(new int[]{destNode, dist[destNode]});
                }
            }
            
        }
        for(int i = 1; i < dist.length; i ++) {
            if(dist[i] <= K) {
                answer ++;
            }
        }
        return answer;
    }
}