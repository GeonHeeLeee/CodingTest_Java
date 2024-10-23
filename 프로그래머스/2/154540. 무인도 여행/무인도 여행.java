import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList();
        int[][] dir = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        List<int[]> island = new ArrayList();
        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i ++) {
            for(int j = 0; j < maps[0].length(); j ++) {
                if(!(maps[i].charAt(j) == 'X')) {
                    island.add(new int[]{i, j, maps[i].charAt(j) - '0'});
                }
            }
        }
        if(island.isEmpty()) {
            return new int[]{-1};
        }

        for(int[] node : island) {
            int y = node[0];
            int x = node[1];
            int food = node[2];
            if(!visited[y][x]) {
                int foodCount = 0;
                queue.add(node);
                visited[y][x] = true;
                while(!queue.isEmpty()) {
                    int[] curNode = queue.poll();
                    int curY = curNode[0];
                    int curX = curNode[1];
                    int curFood = curNode[2];
                    foodCount += curFood;
                    
                    for(int i = 0; i < 4; i ++) {
                        int dy = curY + dir[i][0];
                        int dx = curX + dir[i][1];
                        
                        if(dy>=0 && dy < maps.length && dx>=0 && dx < maps[0].length() && !visited[dy][dx] && !(maps[dy].charAt(dx)=='X')) {
                            queue.add(new int[]{dy, dx, maps[dy].charAt(dx) - '0'});
                            visited[dy][dx] = true;
                        }
                    }
                }
                answer.add(foodCount);
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}