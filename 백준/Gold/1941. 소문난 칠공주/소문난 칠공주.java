import java.io.*;
import java.util.*;

class Main {
    static char[][] room;
    static boolean[] selected = new boolean[25];
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        room = new char[5][5];

        for (int r = 0; r < 5; r++) {
            room[r] = br.readLine().toCharArray();
        }
        getCombinations(0, 0);
        System.out.println(answer);

    }

    public static void getCombinations(int start, int count) {
        if (count == 7) {
            if (isConnected()) {
                answer++;
            }
            return;
        }

        for (int idx = start; idx < 25; idx++) {
            selected[idx] = true;
            getCombinations(idx + 1, count + 1);
            selected[idx] = false;
        }
    }

    public static boolean isConnected() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[25];
        int sCount = 0, connected = 0;

        for (int i = 0; i < 25; i++) {
            if (selected[i]) {
                queue.offer(i);
                visited[i] = true;
                break;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            connected++;

            int row = current / 5;
            int col = current % 5;
            if (room[row][col] == 'S') {
                sCount++;
            }

            for (int[] dir : directions) {
                int dr = dir[0] + row;
                int dc = dir[1] + col;
                int next = dr * 5 + dc;
                if (isInRange(dr, dc) && !visited[next] && selected[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        return connected == 7 && sCount >= 4;
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5;
    }
}