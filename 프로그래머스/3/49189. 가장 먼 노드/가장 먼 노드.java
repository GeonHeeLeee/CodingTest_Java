import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.putIfAbsent(start, new ArrayList());
            graph.putIfAbsent(end, new ArrayList());
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        Queue<Integer> queue = new LinkedList();
        queue.offer(1);
        
        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            for(int neighbor : graph.get(curNode)) {
                if(distance[neighbor] == -1) {
                    distance[neighbor] = distance[curNode] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int maxDistance = Arrays.stream(distance).max().getAsInt();
        int count = (int) Arrays.stream(distance).filter(d -> d == maxDistance).count();

        return count;
    }
    
}