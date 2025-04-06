import java.io.*;
import java.util.*;

class Main {
    static int[] height;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        height = new int[9];

        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, new ArrayList<>(), 0);
    }

    public static void dfs(int index, List<Integer> dwarfs, int sum) {
        if (dwarfs.size() == 7 && sum == 100) {
            Collections.sort(dwarfs);
            for (int h : dwarfs) {
                System.out.println(h);
            }
            found = true;
            return;
        }

        if (sum > 100 || index >= 9 || found) {
            return;
        }

        for (int i = index; i < 9; i++) {
            dwarfs.add(height[i]);
            dfs(i + 1, dwarfs, sum + height[i]);
            dwarfs.remove(dwarfs.size() - 1);
        }
    }
}