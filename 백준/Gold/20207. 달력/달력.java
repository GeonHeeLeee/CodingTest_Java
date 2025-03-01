import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] schedules = new int[n][2];
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
            maxCol = Math.max(maxCol, schedules[i][1]);
        }

        Arrays.sort(schedules, (a, b) -> {
            int result = a[0] - b[0];
            if (result != 0) {
                return result;
            }
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        boolean[][] calender = new boolean[n + 1][maxCol + 1];

        for (int[] schedule : schedules) {
            int start = schedule[0];
            int end = schedule[1];

            while (true) {
                int emptyRow = 0;

                for (int row = 0; row < calender.length; row++) {
                    boolean isEmpty = true;
                    for (int idx = start; idx <= end; idx++) {
                        if (calender[row][idx]) {
                            isEmpty = false;
                            break;
                        }
                    }
                    if (isEmpty) {
                        emptyRow = row;
                        break;
                    }
                }

                for (int idx = start; idx <= end; idx++) {
                    calender[emptyRow][idx] = true;
                }
                break;
            }
        }

        int minIdx = Integer.MAX_VALUE;
        int maxIdx = Integer.MIN_VALUE;
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int sum = 0;

        for (int col = 0; col < calender[0].length; col++) {
            boolean isNotScheduled = true;
            for (int row = 0; row < calender.length; row++) {
                if (calender[row][col]) {
                    isNotScheduled = false;
                    minIdx = Math.min(minIdx, col);
                    maxRow = Math.max(maxRow, row);
                    minRow = Math.min(minRow, row);
                    maxIdx = Math.max(maxIdx, col);
                }
            }
            if ((isNotScheduled && minIdx != Integer.MAX_VALUE)
                    || (minIdx != Integer.MAX_VALUE && col == calender[0].length - 1)) {
                sum += (maxRow - minRow + 1) * (maxIdx - minIdx + 1);
                minIdx = Integer.MAX_VALUE;
                maxIdx = Integer.MIN_VALUE;
                minRow = Integer.MAX_VALUE;
                maxRow = Integer.MIN_VALUE;
            }
        }

        System.out.println(sum);
    }
}