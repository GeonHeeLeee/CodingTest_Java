
import java.io.*;
import java.util.*;

public class Main {
    static boolean[][][] visited = new boolean[61][61][61];
    static int[][] attacks = {
            { 9, 3, 1 }, { 9, 1, 3 },
            { 3, 9, 1 }, { 3, 1, 9 },
            { 1, 3, 9 }, { 1, 9, 3 }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scv = new int[3];
        for (int idx = 0; idx < n; idx++) {
            scv[idx] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(scv);
        visited[scv[0]][scv[1]][scv[2]] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int first = current[0];
                int second = current[1];
                int third = current[2];

                if (first == 0 && second == 0 && third == 0) {
                    System.out.println(count);
                    return;
                }

                for (int[] attack : attacks) {
                    int dFirst = Math.max(0, first - attack[0]);
                    int dSecond = Math.max(0, second - attack[1]);
                    int dThird = Math.max(0, third - attack[2]);

                    if (!visited[dFirst][dSecond][dThird]) {
                        int[] next = new int[] { dFirst, dSecond, dThird };
                        queue.offer(next);
                        visited[dFirst][dSecond][dThird] = true;
                    }
                }
            }
            count++;
        }

    }
}
