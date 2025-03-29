import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] nodes;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int edgeCounts = Integer.parseInt(st.nextToken());

            for (int j = 0; j < edgeCounts; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        List<Integer> selected = new ArrayList<>();
        for (int size = 1; size <= n / 2; size++) {
            generateCombinations(1, size, selected);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void generateCombinations(int start, int size, List<Integer> selected) {
        if (selected.size() == size) {
            checkGroups(selected);
            return;
        }

        for (int i = start; i <= n; i++) {
            selected.add(i);
            generateCombinations(i + 1, size, selected);
            selected.remove(selected.size() - 1);
        }
    }

    public static void checkGroups(List<Integer> groupA) {
        List<Integer> groupB = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!groupA.contains(i)) {
                groupB.add(i);
            }
        }

        if (groupA.isEmpty() || groupB.isEmpty()) {
            return;
        }

        if (isConnected(groupA) && isConnected(groupB)) {
            int sumA = 0;
            int sumB = 0;

            for (int node : groupA) {
                sumA += nodes[node];
            }
            for (int node : groupB) {
                sumB += nodes[node];
            }

            answer = Math.min(answer, (int) Math.abs(sumA - sumB));
        }
    }

    public static boolean isConnected(List<Integer> group) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (group.contains(next) && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return group.size() == count;
    }
}