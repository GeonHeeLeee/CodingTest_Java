import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int r;
    static int c;
    static int d;
    static int cleanCount = 0;
    static int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[n][m];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                room[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(d, r, c);
        System.out.println(cleanCount);
    }

    public static void dfs(int currentD, int row, int col) {
        if (room[row][col] == 0) {
            room[row][col] = 2;
            cleanCount++;
        }

        boolean isCleanable = false;

        for (int[] direction : directions) {
            int dr = direction[0] + row;
            int dc = direction[1] + col;

            if (isInRange(dr, dc)) {
                if (room[dr][dc] == 0) {
                    isCleanable = true;
                }
            }
        }
        if (!isCleanable) {
            int reverseR = row - directions[currentD][0];
            int reverseC = col - directions[currentD][1];
            if (isInRange(reverseR, reverseC) && room[reverseR][reverseC] != 1) {
                dfs(currentD, reverseR, reverseC);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                currentD = currentD == 0 ? 3 : currentD - 1;
                int rotateR = row + directions[currentD][0];
                int rotateC = col + directions[currentD][1];
                
                if (isInRange(rotateR, rotateC) && room[rotateR][rotateC] == 0) {
                    dfs(currentD, rotateR, rotateC);
                    break;
                }
            }
        }

    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}