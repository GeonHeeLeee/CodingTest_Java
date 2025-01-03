import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            if(width == 0 && height == 0) {
                break;
            }
            int[][] graph = new int[height][width];
            for(int h = 0; h < height; h ++) {
                st = new StringTokenizer(br.readLine());
                for(int w = 0; w < width; w ++) {
                     graph[h][w] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            boolean[][] visited = new boolean[height][width];
            int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
            
            for(int h = 0; h < height; h ++) {
                for(int w = 0; w < width; w++) {
                    if(!visited[h][w] && graph[h][w] == 1) {
                        Queue<int[]> queue = new LinkedList<int[]>();
                        queue.offer(new int[]{h, w});
                        visited[h][w] = true;
                        answer ++;
                        while(!queue.isEmpty()) {
                            int[] node = queue.poll();
                            for(int[] dir : directions) {
                                int dh = node[0] + dir[0];
                                int dw = node[1] + dir[1];
                                if(dh >= 0 && dh < height && dw >= 0 && dw < width && graph[dh][dw] == 1 && !visited[dh][dw]) {
                                    queue.add(new int[]{dh, dw});
                                    visited[dh][dw] = true;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(answer);

        }
        
    }
}
