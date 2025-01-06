import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) {
                break;
            }
            arr = new int[n];
            for(int idx = 0; idx < n; idx ++) {
                arr[idx] = Integer.parseInt(st.nextToken());
            }
            dfs(new ArrayList<>(), 0);
            System.out.println();
        }
    }

    public static void dfs(List<Integer> combinations, int index) {
        if(combinations.size() == 6) {
            for(int num : combinations) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for(int idx = index; idx < n; idx ++) {
            combinations.add(arr[idx]);
            dfs(combinations, idx + 1);
            combinations.remove(combinations.size() - 1);
        }
    }
}
