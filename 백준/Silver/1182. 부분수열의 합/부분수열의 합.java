import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for(int idx = 0; idx < n; idx ++) {
            input[idx] = Integer.parseInt(st.nextToken());
        }
        dfs(input, 0, 0);
        if(s == 0) {
            answer --;
        }
        System.out.println(answer);

    }

    public static void dfs(int[] input, int idx, int sum) {
        if(idx == n) {
            if(sum == s) {
                answer ++;
            }
            return;
        }
        dfs(input, idx + 1, sum + input[idx]);
        dfs(input, idx + 1, sum);
    }
}