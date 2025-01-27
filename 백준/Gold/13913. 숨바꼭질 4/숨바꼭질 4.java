import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] location;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        location = new int[100001];
        prev = new int[100001];
        Arrays.fill(location, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        location[n] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == k) {
                break;
            }

            for (int next : new int[] { current - 1, current + 1, 2 * current }) {
                if (next >= 0 && next < 100001 && location[next] == -1) {
                    location[next] = location[current] + 1;
                    prev[next] = current;
                    queue.offer(next);
                }
            }
        }

        System.out.println(location[k]);
        List<Integer> path = new ArrayList<>();
        for (int i = k; i != n; i = prev[i]) {
            path.add(i);
        }
        path.add(n);
        Collections.reverse(path);

        for (int p : path) {
            System.out.print(p + " ");
        }

    }

}
