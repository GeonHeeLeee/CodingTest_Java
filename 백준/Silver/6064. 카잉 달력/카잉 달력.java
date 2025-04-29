import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int trial = 0; trial < t; trial++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> possibles = new HashMap<>();
            int lca = lca(m, n);
            for (int i = x; i <= lca; i += m) {
                possibles.put(i, 1);
            }

            boolean isFound = false;
            for (int i = y; i <= lca; i += n) {
                if (possibles.containsKey(i)) {
                    System.out.println(i);
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println(-1);
            }
        }
    }

    public static int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static int lca(int a, int b) {
        return a * b / (gcd(a, b));
    }
}