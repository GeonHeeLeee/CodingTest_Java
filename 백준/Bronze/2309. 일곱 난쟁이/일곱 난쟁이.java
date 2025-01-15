import java.util.*;
import java.io.*;
public class Main {
    static int[] height;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = new int[9];
        answer = new int[9];
        for(int idx = 0; idx < 9; idx ++) {
            height[idx] = Integer.parseInt(br.readLine());
        }
        dfs(0, 0, 0);

    }
    public static void dfs(int sum, int index, int count) {
        if(sum == 100 && count == 7) {
            Arrays.sort(answer);
            Arrays.stream(answer).filter(h -> h != 0).forEach(height -> System.out.println(height));
            System.exit(0);
        }
        if(sum > 100 || index >= 9) {
            return;
        }
        answer[index] = height[index];
        dfs(sum + height[index], index + 1, count + 1);
        answer[index] = 0;
        dfs(sum, index + 1, count);
    }
}
