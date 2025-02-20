import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            map[row][col] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<int[]> movement = new LinkedList<>();

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            movement.offer(new int[] { time, direction.equals("D") ? 1 : -1 });
        }
        Set<String> body = new HashSet<>();
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[] { 0, 0 });
        body.add(0 + "," + 0);

        int time = 0;
        int dIdx = 0;
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nextRow = head[0] + directions[dIdx][0];
            int nextCol = head[1] + directions[dIdx][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                break;
            }

            if (body.contains(nextRow + "," + nextCol)) {
                break;
            }

            snake.offerFirst(new int[] { nextRow, nextCol });
            body.add(nextRow + "," + nextCol);

            if (map[nextRow][nextCol] == 0) {
                int[] tail = snake.pollLast();
                body.remove(tail[0] + "," + tail[1]);
            } else {
                map[nextRow][nextCol] = 0;
            }

            if (!movement.isEmpty() && time == movement.peek()[0]) {
                int[] current = movement.poll();
                int way = current[1];
                if (way == 1) {
                    dIdx = dIdx == 3 ? 0 : dIdx + 1;
                } else {
                    dIdx = dIdx == 0 ? 3 : dIdx - 1;
                }
            }

        }
        System.out.println(time);
    }
}