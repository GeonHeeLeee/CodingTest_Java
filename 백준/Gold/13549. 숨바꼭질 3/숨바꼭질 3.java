import java.util.*;

public class Main {
    static int N, K;
    static int[] dist;
    static int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        sc.close();

        System.out.println(bfs(N));
    }

    static int bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        dist[start] = 0;
        deque.add(start);

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            if (cur == K) {
                return dist[cur];
            }

            int[] nextPositions = {cur * 2, cur - 1, cur + 1};
            int[] costs = {0, 1, 1};

            for (int i = 0; i < 3; i++) {
                int next = nextPositions[i];
                int cost = costs[i];

                if (next >= 0 && next <= MAX && dist[next] == -1) {
                    dist[next] = dist[cur] + cost;
                    if (cost == 0) {
                        deque.addFirst(next);
                    } else {
                        deque.addLast(next);
                    }
                }
            }
        }
        return -1;
    }
}
