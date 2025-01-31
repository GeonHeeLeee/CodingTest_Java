import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;

        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        int[][] direction = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        char[][] room = new char[n][m];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            room[row] = st.nextToken().toCharArray();
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[] { x1, y1, 0 });
        visited[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int time = current[2];

            if (curX == x2 && curY == y2) {
                System.out.println(time);
                return;
            }

            for (int[] dir : direction) {
                int dx = curX + dir[0];
                int dy = curY + dir[1];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy]) {
                    if (room[dx][dy] == '0') {
                        queue.offerFirst(new int[] { dx, dy, time });
                    } else {
                        queue.offerLast(new int[] { dx, dy, time + 1 });
                    }
                    visited[dx][dy] = true;

                }

            }

        }

    }
}
