import java.util.*;
import java.io.*;
public class Main {
    static int l;
    static int destY;
    static int destX;
    static boolean[][] visited;
    static int answer;
    static int[][] directions = {
        {1, 2}, {2, 1}, {2, -1}, {1, -2},
        {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int startY;
        int startX;


        for(int trial = 0; trial < n; trial ++) {
            answer = Integer.MAX_VALUE;
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            bfs(startY, startX);
            System.out.println(answer);
        }

    }
    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX, 0});
        visited[startY][startX] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curY = current[0];
            int curX = current[1];
            int count = current[2];

            if(curY == destY && curX == destX) {
                answer = count;
                return;
            }

            for(int[] dir : directions) {
                int dy = dir[0] + curY;
                int dx = dir[1] + curX;
                
                if(dy >= 0 && dy < l && dx >= 0 && dx < l && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    queue.offer(new int[]{dy, dx, count + 1});
                }
            }
        }
    }
}
