import java.util.*;
import java.io.*;
public class Main {
    static int height;
    static int width;
    static int[][] plate;
    static int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int[] trial = new int[100];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        plate = new int[height][width];
        
        for(int row = 0; row < height; row ++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < width; col ++) {
                plate[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        
        Arrays.fill(trial, -1);
        for(int time = 0; time < 100; time ++) {
            bfs(time);
            if(trial[time] == 0) {
                System.out.println(time);
                System.out.println(trial[time-1]);
                break;
            }
        }
    }

    public static void bfs(int time) {
        boolean[][] visited = new boolean[height][width];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int cheeseCount = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int[] dir : directions) {
                int dy = dir[0] + current[0];
                int dx = dir[1] + current[1];

                if(dy >= 0 && dy < height && dx >= 0 && dx < width && !visited[dy][dx]) {
                    if(plate[dy][dx] == 0) {
                        queue.add(new int[]{dy, dx});
                    }
                    if(plate[dy][dx] == 1) {
                        cheeseCount ++;
                        plate[dy][dx] = 0;
                    }
                    visited[dy][dx] = true;
                }
            }
        }
        trial[time] = cheeseCount;
    }
}
