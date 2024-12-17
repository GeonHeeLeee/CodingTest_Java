import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        //가중치 기준 오름차순 정렬
        Arrays.sort(costs, (a,b) -> a[2]-b[2]);
        
        int[] parent = new int[n];
        for(int idx = 0; idx < n; idx ++) {
            parent[idx] = idx;    
        }
        
        for(int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];
            
            if(find(parent, start) != find(parent, end)) {
                union(parent, start, end);
                answer += weight;
            }
        }
        
        
        return answer;
    }
    
    public int find(int[] parent, int node) {
        if(parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
    
    public void union(int[] parent, int node1, int node2) {
        int root1 = find(parent, node1);
        int root2 = find(parent, node2);
        
        parent[root2] = root1;
    }
}