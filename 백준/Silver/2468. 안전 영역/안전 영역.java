import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxRegion = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        int[][] region = new int[n][n];
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        StringTokenizer st;
        for(int row = 0; row < n; row ++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < n; col ++) {
                region[row][col] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, region[row][col]);
                minHeight = Math.min(minHeight, region[row][col]);
            }   
        }

        for(int rain = minHeight - 1; rain <= maxHeight + 1; rain ++) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            int regionCount = 0;
            for(int row = 0; row < n; row ++) {
                for(int col = 0; col < n; col ++) {
                    if(!visited[row][col] && region[row][col] > rain) {
                        queue.offer(new int[]{row, col});
                        visited[row][col] = true;
                        regionCount += 1;
                        while(!queue.isEmpty()) {
                            int[] curRegion = queue.poll();
                            for(int[] dir : direction) {
                                int dy = dir[0] + curRegion[0];
                                int dx = dir[1] + curRegion[1];
                                if(dy >= 0 && dy < n && dx >= 0 && dx < n && !visited[dy][dx] && region[dy][dx] > rain) {
                                    queue.offer(new int[]{dy, dx});
                                    visited[dy][dx] = true;
                                }
                            }
                        }
                    }
                }
            }
            maxRegion = Math.max(maxRegion, regionCount);
        }
        System.out.println(maxRegion);
    }
}
