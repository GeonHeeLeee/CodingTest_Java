import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static Map<Integer, Node> tree = new HashMap<>();

    static class Node {
        int value;
        Node parent;
        List<Node> children = new ArrayList<>();
        int depth;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            tree.put(i, new Node(i));
        }

        Node root = tree.get(1);
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Node nodeA = tree.get(a);
            Node nodeB = tree.get(b);

            nodeA.children.add(nodeB);
            nodeB.children.add(nodeA);
        }

        makeTree(null, root, 0);

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node a = tree.get(Integer.parseInt(st.nextToken()));
            Node b = tree.get(Integer.parseInt(st.nextToken()));

            Node lca = getLCA(a, b);
            System.out.println(lca.value);
        }
    }

    public static void makeTree(Node parent, Node current, int depth) {
        current.parent = parent;
        current.depth = depth;

        if (current.parent != null) {
            current.children.remove(parent);
        }

        for (Node child : current.children) {
            makeTree(current, child, depth + 1);
        }
    }

    public static Node getLCA(Node a, Node b) {
        while (a.depth > b.depth) {
            a = a.parent;
        }

        while (a.depth < b.depth) {
            b = b.parent;
        }

        while (a != b) {
            a = a.parent;
            b = b.parent;
        }

        return a;
    }
}