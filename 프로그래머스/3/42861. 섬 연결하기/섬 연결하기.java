import java.util.*;

class Edge {
    int node1;
    int node2;
    int cost;
    
    public Edge(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }
}
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge> edgeList = new ArrayList<>();
        int[] parent = new int[n+1];
        
        for(int i = 1; i <= n; i ++) {
            parent[i] = i;
        }
        
        for(int[] cost : costs) {
            int node1 = cost[0];
            int node2 = cost[1];
            int edgeCost = cost[2];
            
            Edge edge = new Edge(node1, node2, edgeCost);
            edgeList.add(edge);
        }
        
        Collections.sort(edgeList, (a,b) -> Integer.compare(a.cost, b.cost));
        
        for(Edge edge : edgeList) {
            int node1 = edge.node1;
            int node2 = edge.node2;
            int cost = edge.cost;
            
            if(find(node1, parent) != find(node2, parent)) {
                union(node1, node2, parent);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    public int find(int node, int[] parent) {
        if(parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }
        
        return parent[node];
    }
    
    public void union(int node1, int node2, int[] parent) {
        int root1 = find(node1, parent);
        int root2 = find(node2, parent);
        
        parent[root2] = root1;
    }
}