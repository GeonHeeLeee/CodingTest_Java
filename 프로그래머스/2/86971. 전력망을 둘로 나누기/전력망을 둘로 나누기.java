import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i ++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList();
            queue.add(wires[i][0]);
            visited[wires[i][0]] = true;
            int count = 1;
            while(!queue.isEmpty()) {
                int curNode = queue.poll();
                for(int j = 0; j < wires.length; j ++) {
                    if(i == j) {
                        continue;
                    }
                    
                    int start = wires[j][0];
                    int end = wires[j][1];
                    
                    if(start == curNode && !visited[end]) {
                        queue.add(end);
                        visited[end] = true;
                        count ++;
                    } else if(end == curNode && !visited[start]) {
                        queue.add(start);
                        visited[start] = true;
                        count ++;
                    }
                }
            }
            answer = Math.min(answer, Math.abs(count - (n - count)));
        }
        return answer;
    }
}