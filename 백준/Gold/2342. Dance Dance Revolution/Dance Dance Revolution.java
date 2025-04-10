import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;
        List<Integer> commands = new ArrayList<>();
        while (true) {
            int next = Integer.parseInt(st.nextToken());
            if (next == 0) {
                break;
            }
            commands.add(next);
        }
        int n = commands.size();
        int[][][] dp = new int[5][5][n + 1];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        dp[0][0][0] = 0;

        for (int step = 0; step < n; step++) {
            int next = commands.get(step);

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    int cost = dp[l][r][step];
                    if (cost == Integer.MAX_VALUE) {
                        continue;
                    }

                    if (next != r) {
                        int moveLeft = move(l, next);
                        dp[next][r][step + 1] = Math.min(dp[next][r][step + 1], cost + moveLeft);

                    }

                    if (next != l) {
                        int moveRight = move(r, next);
                        dp[l][next][step + 1] = Math.min(dp[l][next][step + 1], cost + moveRight);
                    }

                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                answer = Math.min(answer, dp[l][r][n]);
            }
        }

        System.out.println(answer);
    }

    public static int move(int current, int next) {
        if (current == next) {
            return 1;
        }

        if (current == 0) {
            return 2;
        }

        if ((current == 2 && next == 4) || (current == 1 && next == 3) || (current == 3 && next == 1)
                || (current == 4 && next == 2)) {
            return 4;
        }

        if ((current == 2 && (next == 1 || next == 3)) || (current == 1 && (next == 2 || next == 4))
                || (current == 3 && (next == 2 || next == 4))
                || (current == 4 && (next == 1 || next == 3))) {
            return 3;
        }

        return -1;
    }
}