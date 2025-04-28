import java.io.*;
import java.util.*;

class Main {
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        int[][] paper = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!visited[r][c] && paper[r][c] == 1) {
                    queue.offer(new int[] { r, c });
                    visited[r][c] = true;
                    count++;
                    int temp = 0;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        temp++;
                        int curRow = current[0];
                        int curCol = current[1];

                        for (int[] dir : directions) {
                            int dr = dir[0] + curRow;
                            int dc = dir[1] + curCol;

                            if (isInRange(dr, dc, n, m) && !visited[dr][dc] && paper[dr][dc] == 1) {
                                queue.offer(new int[] { dr, dc });
                                visited[dr][dc] = true;
                            }
                        }
                    }
                    max = Math.max(max, temp);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static boolean isInRange(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}