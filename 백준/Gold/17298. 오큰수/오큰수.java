import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] NGE = new int[n];
        Stack<int[]> stack = new Stack<>();

        for(int idx = 0; idx < n ; idx ++) {
            int input = Integer.parseInt(st.nextToken());
            
            while(!stack.isEmpty() && stack.peek()[1] < input) {
                NGE[stack.pop()[0]] = input;
            }
        
            stack.push(new int[]{idx, input});
        }

        StringBuilder sb = new StringBuilder();
        for(int num : NGE) {

            if(num == 0) {
                sb.append(-1 + " ");
            } else {
                sb.append(num + " ");
            }
        }
        System.out.println(sb.toString());
    }    
}
