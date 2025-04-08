import java.io.*;
import java.util.*;

class Main {
    static int n;
    static Map<Integer, Tree> tree = new HashMap<>();
    static int[][] dp;

    static class Tree {
        Tree parent;
        int value;
        List<Tree> children = new ArrayList<>();

        public Tree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
        for (int node = 1; node <= n; node++) {
            tree.put(node, new Tree(node));
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).children.add(tree.get(b));
            tree.get(b).children.add(tree.get(a));
        }

        Tree root = tree.get(1);
        makeTree(root, null);

        dfs(root);
        System.out.println(Math.min(dp[root.value][0], dp[root.value][1]));
    }

    public static void makeTree(Tree current, Tree parent) {
        current.parent = parent;
        if (current.parent != null) {
            current.children.remove(parent);
        }

        for (Tree child : current.children) {
            makeTree(child, current);
        }
    }

    public static void dfs(Tree tree) {
        int value = tree.value;
        dp[value][0] = 0;
        dp[value][1] = 1;

        for (Tree child : tree.children) {
            dfs(child);
            dp[value][0] += dp[child.value][1];
            dp[value][1] += Math.min(dp[child.value][0], dp[child.value][1]);
        }
    }
}