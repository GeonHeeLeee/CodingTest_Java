import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 500000;
    static boolean[][] visited = new boolean[MAX + 1][2];

    public static int bfs(int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { n, 0 });
        visited[n][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0], time = curr[1];

            int brother = k + time * (time + 1) / 2;
            if (brother > MAX)
                return -1;
            if (visited[brother][time % 2])
                return time;

            int nextTime = time + 1;
            for (int nextPos : new int[] { pos - 1, pos + 1, pos * 2 }) {
                if (nextPos >= 0 && nextPos <= MAX && !visited[nextPos][nextTime % 2]) {
                    visited[nextPos][nextTime % 2] = true;
                    queue.add(new int[] { nextPos, nextTime });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
        } else {
            System.out.println(bfs(n, k));
        }
    }
}
