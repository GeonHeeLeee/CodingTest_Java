import java.io.*;
import java.util.*;

class Main {
    static int n, m, d;
    static int[][] board;
    static List<Integer> archers = new ArrayList<>();
    static int answer = 0;
    static int enermyCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] == 1) {
                    enermyCount++;
                }
            }
        }
        getCombinations(0, 0);

        System.out.println(answer);
    }

    public static void playGame() {
        int[][] tempBoard = new int[n][m];
        for (int r = 0; r < n; r++) {
            tempBoard[r] = board[r].clone();
        }

        int curEnermy = enermyCount;
        int killedEnermy = 0;
        while (curEnermy > 0) {
            List<int[]> enermyList = new ArrayList<>();
            for (int archer : archers) {
                int minDist = Integer.MAX_VALUE;
                int[] temp = new int[2];

                for (int r = n - 1; r >= 0; r--) {
                    for (int c = 0; c < m; c++) {
                        if (tempBoard[r][c] == 1) {
                            int dist = getDistance(n, archer, r, c);
                            if (dist <= minDist && dist <= d) {
                                if (dist == minDist && c > temp[1]) {
                                    continue;
                                }
                                minDist = dist;
                                temp[0] = r;
                                temp[1] = c;
                            }
                        }
                    }
                }
                if (minDist != Integer.MAX_VALUE) {
                    enermyList.add(temp);
                }
            }

            int killed = killEnermy(enermyList, tempBoard);
            curEnermy -= killed;
            killedEnermy += killed;
            curEnermy -= stepForward(tempBoard);
        }
        answer = Math.max(answer, killedEnermy);
    }

    public static int killEnermy(List<int[]> enermyList, int[][] tempBoard) {
        int killed = 0;
        for (int[] enermy : enermyList) {
            if (tempBoard[enermy[0]][enermy[1]] == 1) {
                tempBoard[enermy[0]][enermy[1]] = 0;
                killed++;
            }
        }
        return killed;
    }

    public static int stepForward(int[][] tempBoard) {
        int attacks = 0;
        for (int c = 0; c < m; c++) {
            if (tempBoard[n - 1][c] == 1) {
                attacks++;
            }
        }

        for (int r = n - 1; r > 0; r--) {
            tempBoard[r] = tempBoard[r - 1].clone();
        }

        Arrays.fill(tempBoard[0], 0);

        return attacks;
    }

    public static void getCombinations(int idx, int count) {
        if (count == 3) {
            playGame();
            return;
        }
        for (int index = idx; index < m; index++) {
            archers.add(index);
            getCombinations(index + 1, count + 1);
            archers.remove(archers.size() - 1);
        }
    }

    public static int getDistance(int ar, int ac, int er, int ec) {
        return (int) Math.abs(ar - er) + (int) Math.abs(ac - ec);
    }
}