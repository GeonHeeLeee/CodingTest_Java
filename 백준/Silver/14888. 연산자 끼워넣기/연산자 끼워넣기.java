import java.io.*;
import java.util.*;

public class Main {    
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] numbers;
    static int[] operators = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        numbers = new int[n];


        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < n; idx ++) {
            numbers[idx] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < 4; idx ++) {
            operators[idx] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int index, int sum) {
        if(index == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for(int opIdx = 0; opIdx < 4; opIdx ++) {
            if(operators[opIdx] > 0) {
                int result = operateNumber(opIdx, sum, numbers[index]);
                operators[opIdx] --;
                dfs(index + 1, result);
                operators[opIdx] ++;
            }
        }
    }

    public static int operateNumber(int opIdx, int num1, int num2) {
        int result = 0;
        switch (opIdx) {
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result = num1 - num2;
                break;
            case 2:
                result = num1 * num2;
                break;
            case 3:
                result = num1 / num2;
                break;
        }
        return result;
    }

}
