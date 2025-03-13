import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    static boolean[] truth;

    public static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        parent[root2] = root1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        truth = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        List<List<Integer>> parties = new ArrayList<>();
        List<Integer> truthPeople = new ArrayList<>();
        for (int i = 0; i < truthCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            truthPeople.add(person);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            int firstPerson = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            party.add(firstPerson);
            for (int j = 1; j < partySize; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
                union(firstPerson, person);
            }
            parties.add(party);
        }

        for (int person : truthPeople) {
            truth[find(person)] = true;
        }

        int count = 0;

        for (List<Integer> party : parties) {
            if (!party.isEmpty() && !truth[find(party.get(0))]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
