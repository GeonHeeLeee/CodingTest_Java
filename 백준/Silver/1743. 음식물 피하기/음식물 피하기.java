import java.io.*;
import java.util.*;

class Main {
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int n, m, k;
    static boolean[][] visited;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;

            room[row][col] = 1;
        }

        visited = new boolean[n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (room[r][c] == 1 && !visited[r][c]) {
                    Queue<int[]> queue = new LinkedList<>();
                    visited[r][c] = true;
                    int size = 1;
                    queue.offer(new int[] { r, c, size });

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int curRow = current[0];
                        int curCol = current[1];
                        max = Math.max(size, max);

                        for (int[] dir : directions) {
                            int dr = curRow + dir[0];
                            int dc = curCol + dir[1];

                            if (dr >= 0 && dr < n && dc >= 0 && dc < m && !visited[dr][dc] && room[dr][dc] == 1) {
                                queue.offer(new int[] { dr, dc, ++size });
                                visited[dr][dc] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

}