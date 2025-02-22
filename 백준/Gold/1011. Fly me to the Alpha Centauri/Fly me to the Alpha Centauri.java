import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = y - x;
            System.out.println(getMinMoves(distance));
        }

    }

    public static int getMinMoves(int distance) {
        if (distance == 0) {
            return 0;
        }

        int n = (int) Math.sqrt(distance);

        int square = n * n;
        int remain = distance - square;

        if (remain == 0) {
            return 2 * n - 1;
        } else if (remain <= n) {
            return 2 * n;
        } else {
            return 2 * n + 1;
        }
    }
}