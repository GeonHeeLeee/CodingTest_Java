import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] graph;
    static int[][] distance;
    static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int[] start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        for (int row = 0; row < m; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                graph[row][col] = Integer.parseInt(st.nextToken());
                if (graph[row][col] == 2) {
                    start = new int[] { row, col };
                }
                if (graph[row][col] == 0) {
                    distance[row][col] = 0;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start[0], start[1], 1 });
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            int depth = current[2];

            for (int[] direction : directions) {
                int dr = direction[0] + curRow;
                int dc = direction[1] + curCol;

                if (dr >= 0 && dc >= 0 && dr < m && dc < n && graph[dr][dc] == 1
                        && (distance[dr][dc] == -1 || distance[dr][dc] > depth)) {
                    distance[dr][dc] = depth;
                    queue.offer(new int[] { dr, dc, depth + 1 });
                }
            }
        }

        for (int[] row : distance) {
            for (int land : row) {
                System.out.print(land + " ");
            }
            System.out.println();
        }
    }
}
