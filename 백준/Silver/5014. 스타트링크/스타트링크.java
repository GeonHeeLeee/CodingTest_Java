import java.io.*;
import java.util.*;

class Main {
    static int f, s, g, u, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[f + 1];
        int minButtons = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { s, 0 });
        visited[s] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curFloor = current[0];
            int curButton = current[1];

            if (curFloor == g) {
                minButtons = Math.min(minButtons, curButton);
                continue;
            }
            if (isInRange(curFloor + u) && !visited[curFloor + u]) {
                visited[curFloor + u] = true;
                queue.offer(new int[] { curFloor + u, curButton + 1 });
            }
            if (isInRange(curFloor - d) && !visited[curFloor - d]) {
                visited[curFloor - d] = true;
                queue.offer(new int[] { curFloor - d, curButton + 1 });
            }
        }

        if (minButtons == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(minButtons);
        }
    }

    public static boolean isInRange(int floor) {
        return floor <= f && floor >= 1;
    }
}