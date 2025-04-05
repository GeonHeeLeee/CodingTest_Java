import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] lab;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int emptyCount = 0;
    static List<int[]> viruses = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][n];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                lab[r][c] = Integer.parseInt(st.nextToken());
                if (lab[r][c] == 2) {
                    viruses.add(new int[] { r, c });
                } else if (lab[r][c] == 0) {
                    emptyCount++;
                }
            }
        }

        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }
        getCombinations(0, 0, new ArrayList<>());
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static void spillLab(List<int[]> activatedVirus) {
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int[] v : activatedVirus) {
            queue.offer(new int[] { v[0], v[1], 0 });
            visited[v[0]][v[1]] = true;
        }

        int time = 0;
        int spread = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curRow = current[0];
            int curCol = current[1];
            int curTime = current[2];

            for (int[] dir : directions) {
                int dr = dir[0] + curRow;
                int dc = dir[1] + curCol;

                if (!isInRange(dr, dc) || visited[dr][dc] || lab[dr][dc] == 1)
                    continue;

                visited[dr][dc] = true;
                if (lab[dr][dc] == 0) {
                    spread++;
                    time = curTime + 1;
                }
                queue.offer(new int[] { dr, dc, curTime + 1 });

            }

        }

        if (spread == emptyCount) {
            answer = Math.min(answer, time);
        }
    }

    public static void getCombinations(int index, int count, List<int[]> current) {
        if (count == m) {
            spillLab(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < viruses.size(); i++) {
            current.add(viruses.get(i));
            getCombinations(i + 1, count + 1, current);
            current.remove(current.size() - 1);
        }
    }

}