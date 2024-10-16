import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[][] d = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int[][] dist = new int[maps.length][maps[0].length()];
        String[][] map = new String[maps.length][maps[0].length()];
        int[] start = new int[]{0,0};
        int[] end = new int[]{0,0};
        int[] lever = new int[]{0,0};
        for(int i = 0; i < maps.length; i ++) {
            map[i] = maps[i].split("");
            for(int j = 0; j < maps[0].length(); j ++) {
                dist[i][j] = Integer.MAX_VALUE;
                if(map[i][j].equals("S")) {
                    start = new int[]{i, j};
                } else if(map[i][j].equals("E")) {
                    end = new int[]{i, j};
                } else if(map[i][j].equals("L")) {
                    lever = new int[]{i, j};
                }
            }
        }
        int toDist = bfs(start, lever, dist, map, d);
        
        for(int i = 0; i < dist.length; i ++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        int toEnd = bfs(lever, end, dist, map, d);
        
        if(toDist == -1 || toEnd == -1) {
            return -1;
        }
        return toDist + toEnd;

    }
    
    public int bfs(int[] start, int[] target, int[][] dist, String[][] map, int[][] d) {
        Queue<int[]> queue = new LinkedList();
        queue.add(start);
        dist[start[0]][start[1]] = 0;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            
            if(y == target[0] && x == target[1]) {
                return dist[y][x];
            }
            for(int i = 0; i < 4; i ++) {
                int[] dir = d[i];
                int dy = y + dir[0];
                int dx = x + dir[1];
                if(dx >= 0 && dx < dist[0].length && dy >= 0 && dy < dist.length && !map[dy][dx].equals("X")) {
                    if(dist[y][x] + 1 < dist[dy][dx]) {
                        dist[dy][dx] = dist[y][x] + 1;
                        queue.add(new int[]{dy, dx});
                    }
                }
            }
        }
        return -1;
    }
}