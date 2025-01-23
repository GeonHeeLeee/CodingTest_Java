import java.util.*;
import java.io.*;

public class Main {
    static int r;
    static int c;
    static List<int[]> fireList = new ArrayList<>();
    static int[] start;
    static int minTime = Integer.MAX_VALUE;
    static int[][] fireMap;
    static int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        fireMap = new int[r][c];
        Queue<int[]> fireQueue = new LinkedList<>();
        for (int row = 0; row < r; row++) {
            String[] input = br.readLine().split("");
            Arrays.fill(fireMap[row], Integer.MAX_VALUE);
            for (int col = 0; col < c; col++) {
                String current = input[col];
                if (current.equals("F")) {
                    fireQueue.offer(new int[] { row, col });
                    fireMap[row][col] = 0;
                } else if (current.equals("J")) {
                    start = new int[] { row, col };
                } else if (current.equals("#")) {
                    fireMap[row][col] = -1;
                }
            }
        }

        spreadFire(fireQueue);
        escape();

        System.out.println(minTime == Integer.MAX_VALUE ? "IMPOSSIBLE" : minTime);
    }

    public static void spreadFire(Queue<int[]> fireQueue) {

        boolean[][] visited = new boolean[r][c];

        while (!fireQueue.isEmpty()) {
            int[] current = fireQueue.poll();
            int time = fireMap[current[0]][current[1]];

            for (int[] dir : direction) {
                int dy = dir[0] + current[0];
                int dx = dir[1] + current[1];

                if (dy >= 0 && dy < r && dx >= 0 && dx < c && fireMap[dy][dx] == Integer.MAX_VALUE) {
                    fireQueue.offer(new int[] { dy, dx });
                    fireMap[dy][dx] = time + 1;
                }
            }
        }

    }

    public static void escape() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        queue.offer(new int[] { start[0], start[1], 0 });
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int time = current[2];

            if (current[0] == r - 1 || current[1] == c - 1 || current[0] == 0 || current[1] == 0) {
                minTime = time + 1;
                return;
            }
            

            for (int[] dir : direction) {
                int dy = dir[0] + current[0];
                int dx = dir[1] + current[1];
                if (dy >= 0 && dy < r && dx >= 0 && dx < c && !visited[dy][dx] && time + 1 < fireMap[dy][dx]
                        && fireMap[dy][dx] != -1) {
                    queue.offer(new int[] { dy, dx, time + 1 });
                    visited[dy][dx] = true;
                }
            }
        }
    }
}
