import java.io.*;
import java.util.*;

class Main {
    static int n, l;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < n; r++) {
            if (canPass(map[r])) {
                answer++;
            }
        }

        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];

            for (int r = 0; r < n; r++) {
                colArray[r] = map[r][c];
            }

            if (canPass(colArray)) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static boolean canPass(int[] line) {
        boolean[] isRamp = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            if (line[i] == line[i + 1]) {
                continue;
            }

            if (Math.abs(line[i] - line[i + 1]) > 1) {
                return false;
            }

            if (line[i] < line[i + 1]) {
                if (i - l + 1 < 0) {
                    return false;
                }

                for (int j = i; j >= i - l + 1; j--) {
                    if (line[j] != line[i] || isRamp[j]) {
                        return false;
                    }
                }

                for (int j = i; j >= i - l + 1; j--) {
                    isRamp[j] = true;
                }
            } else {
                if (i + l > n - 1) {
                    return false;
                }

                for (int j = i + 1; j <= i + l; j++) {
                    if (line[j] != line[i + 1] || isRamp[j]) {
                        return false;
                    }
                }
                for (int j = i + 1; j <= i + l; j++) {
                    isRamp[j] = true;
                }
            }
        }

        return true;
    }
}