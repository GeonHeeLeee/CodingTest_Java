import java.io.*;
import java.util.*;

class Main {
    static class Person {
        int value;
        List<Person> children = new ArrayList<>();

        public Person(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Person> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new Person(i));
        }

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            Person person1 = graph.get(p1);
            Person person2 = graph.get(p2);

            person1.children.add(person2);
            person2.children.add(person1);
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(new int[] { a, 0 });
        visited[a] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curP = current[0];
            int depth = current[1];

            for (Person next : graph.get(curP).children) {
                if (next.value == b) {
                    System.out.println(depth + 1);
                    return;
                }

                if (!visited[next.value]) {
                    queue.offer(new int[] { next.value, depth + 1 });
                    visited[next.value] = true;
                }
            }
        }

        System.out.println(-1);

    }
}