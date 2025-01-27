import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] location;
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        location = new int[100001];

        Arrays.fill(location, -1);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { n, 0 });
        location[n] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int time = current[1];
            
            if (x == k) {
                if(time < minTime) {
                    minTime = time;
                    count = 1;
                } else if(time == minTime) {
                    count ++;
                }
                continue;
            }

            if (x + 1 < location.length && (location[x + 1] == -1 || time + 1 <= location[x + 1])) {
                queue.offer(new int[] { x + 1, time + 1 });
                location[x + 1] = time + 1;
            }
            if (x - 1 >= 0 && (location[x - 1] == -1 || time + 1 <= location[x - 1])) {
                queue.offer(new int[] { x - 1, time + 1 });
                location[x - 1] = time + 1;
            }
            if (2 * x < location.length && (location[2 * x] == -1 || time + 1 <= location[2 * x])) {
                queue.offer(new int[] { 2 * x, time + 1 });
                location[2 * x] = time + 1;
            }

        }

        System.out.println(minTime);
        System.out.println(count);

    }
}
