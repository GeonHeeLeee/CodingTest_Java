import java.util.*;

class Node {
    int value;
    List<Node> connected = new ArrayList<>();
    
    public Node(int value) {
        this.value = value;
    }
}
class Solution {
    int answer = Integer.MAX_VALUE;
    Map<Integer, Node> nodeMap = new HashMap();
    public int solution(int n, int[][] wires) {
        for(int i = 1; i <= n; i ++) {
            Node node = new Node(i);
            nodeMap.put(i, node);
            
            
        }
        
        for(int[] wire : wires) {
            Node node1 = nodeMap.get(wire[0]);
            Node node2 = nodeMap.get(wire[1]);
            
            node1.connected.add(node2);
            node2.connected.add(node1);
        }
        
        for(int[] wire : wires) {
            int start = wire[0];
            int dest = wire[1];
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            queue.offer(1);
            visited[1] = true;
            
            while(!queue.isEmpty()) {
                int current = queue.poll();
                for(Node next : nodeMap.get(current).connected) {
                    if(!visited[next.value]) {
                        if(!(current == start && next.value == dest) && !(current == dest && next.value == start)) {
                            queue.offer(next.value);
                            visited[next.value] = true;
                        }
                    }
                }
            }
            int count = 0;
            for(int i = 1; i <= n; i ++) {
                if(visited[i]) {
                    count ++;
                }
            }
            int remain = n - count;
            answer = Math.min(answer, Math.abs(remain - count));
        }
        return answer;
    }
}