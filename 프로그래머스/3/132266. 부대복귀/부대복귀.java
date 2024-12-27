import java.util.*;
class Node {
    int index;
    int count;
    
    public Node(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new ArrayList()).add(road[1]);
            graph.computeIfAbsent(road[1], k -> new ArrayList()).add(road[0]);
        }

        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(destination, 0));
        cost[destination] = 0;
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentIndex = currentNode.index;
            int count = currentNode.count;
            if(currentIndex == destination) {
                cost[currentIndex] = count;
            }
            if(!graph.containsKey(currentIndex)) {
                break;
            }

            for(int nextIndex : graph.get(currentIndex)) {
                if(count + 1 <= cost[nextIndex]) {
                    queue.offer(new Node(nextIndex, count + 1));
                    cost[nextIndex] = count + 1;
                }
            }
        }

        for(int idx = 0; idx < sources.length; idx ++) {
            answer[idx] = cost[sources[idx]] == Integer.MAX_VALUE ? -1 : cost[sources[idx]];
        }

        return answer;
    }
}