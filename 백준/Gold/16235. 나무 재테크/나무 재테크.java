import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static int[][] A;
    static int[][] land;
    static PriorityQueue<Tree> treePQ = new PriorityQueue<>((a, b) -> Integer.compare(a.age, b.age));
    static Queue<Tree> deadTree = new LinkedList<>();
    static int[][] nears = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
            { -1, -1 } };

    static class Tree {
        int row;
        int col;
        int age;

        public Tree(int row, int col, int age) {
            this.row = row;
            this.col = col;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[n][n];
        land = new int[n][n];

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                land[r][c] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());

            Tree tree = new Tree(row, col, age);
            treePQ.add(tree);
        }

        for (int year = 0; year < k; year++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(treePQ.size());
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static PriorityQueue<Tree> getNewPQ() {
        return new PriorityQueue<Tree>((a, b) -> Integer.compare(a.age, b.age));
    }

    public static void spring() {
        PriorityQueue<Tree> newPQ = getNewPQ();
        while (!treePQ.isEmpty()) {
            Tree tree = treePQ.poll();
            int row = tree.row;
            int col = tree.col;
            int age = tree.age;

            if (land[row][col] >= age) {
                land[row][col] -= age;
                tree.age++;
                newPQ.offer(tree);
            } else {
                deadTree.offer(tree);
            }
        }
        treePQ = newPQ;
    }

    public static void summer() {
        while (!deadTree.isEmpty()) {
            Tree curTree = deadTree.poll();

            int row = curTree.row;
            int col = curTree.col;
            int age = curTree.age;

            land[row][col] += (age / 2);
        }
    }

    public static void fall() {
        PriorityQueue<Tree> newPQ = getNewPQ();
        while (!treePQ.isEmpty()) {
            Tree tree = treePQ.poll();
            int row = tree.row;
            int col = tree.col;
            int age = tree.age;
            newPQ.offer(tree);
            if (age % 5 != 0) {
                continue;
            }

            for (int[] near : nears) {
                int dr = row + near[0];
                int dc = col + near[1];

                if (isInRange(dr, dc)) {
                    Tree newTree = new Tree(dr, dc, 1);
                    newPQ.offer(newTree);
                }
            }

        }
        treePQ = newPQ;
    }

    public static void winter() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                land[r][c] += A[r][c];
            }
        }
    }

}