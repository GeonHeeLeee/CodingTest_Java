import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> start = new ArrayList<>();
        start.add(1);
        queue.offer(start);

        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int num = current.get(current.size() - 1);

            if (num == n) {
                StringBuilder sb = new StringBuilder();
                System.out.println(current.size() - 1);
                for (int i = current.size() - 1; i >= 0; i--) {
                    sb.append(current.get(i)).append(" ");
                }
                System.out.println(sb.toString());
                return;
            }

            if (num * 3 <= n && dist[num * 3] > dist[num] + 1) {
                dist[num * 3] = dist[num] + 1;
                List<Integer> temp = new ArrayList<>(current);
                temp.add(num * 3);
                queue.offer(temp);
            }

            if (num * 2 <= n && dist[num * 2] > dist[num] + 1) {
                dist[num * 2] = dist[num] + 1;
                List<Integer> temp = new ArrayList<>(current);
                temp.add(num * 2);
                queue.offer(temp);
            }

            if (num + 1 <= n && dist[num + 1] > dist[num] + 1) {
                dist[num + 1] = dist[num] + 1;
                List<Integer> temp = new ArrayList<>(current);
                temp.add(num + 1);
                queue.offer(temp);

            }
        }
    }
}