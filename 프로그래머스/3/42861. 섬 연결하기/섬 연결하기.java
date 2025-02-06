import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // 크루스칼 알고리즘 -> 최소 신장 트리 찾기 위함
        //간선의 가중치가 작은 것 순으로 정렬
        Arrays.sort(costs, (a,b) -> (a[2] - b[2]));
        int[] parent = new int[n];
        for(int idx = 0; idx < n; idx ++) {
            parent[idx] = idx; // 모든 노드를 독립적인 것으로 보고 자기 자신의 부모는 자기 자신으로 설정
        }
        
        for(int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];
            
            //만약 시작과 끝의 부모가 같지 않으면
            if(find(parent, start) != find(parent, end)) {
                union(parent, start, end); //병합
                answer += weight; //가중치 추가
            }
            
        }
        return answer;
    }
    
    //부모를 찾는 메서드
    public int find(int[] parent, int node) {
        if(parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        //그니까 병합할때 자기 자신을 부모로 가지는 노드를 설정하고, 이에 병합하는 방식
        return parent[node];
    }
    
    //병합하는 메서드
    public void union(int[] parent, int node1, int node2) {
        int root1 = find(parent, node1);
        int root2 = find(parent, node2);
        
        parent[root2] = root1;
    }
}