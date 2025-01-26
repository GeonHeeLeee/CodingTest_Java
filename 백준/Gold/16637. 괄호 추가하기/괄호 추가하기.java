import java.io.*;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static String expression;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        expression = br.readLine();

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int index, int currentResult) {
        if (index >= n) {
            answer = Math.max(answer, currentResult);
            return;
        }

        int num = expression.charAt(index) - '0';
        if (index == 0) {
            dfs(index + 2, num);
        } else {
            char operator = expression.charAt(index - 1);
            dfs(index + 2, operate(currentResult, operator, num));

            if (index + 2 < n) {
                char nextOperator = expression.charAt(index + 1);
                int nextNum = expression.charAt(index + 2) - '0';
                int nextResult = operate(num, nextOperator, nextNum);

                dfs(index + 4, operate(currentResult, operator, nextResult));
            }
        }
    }

    public static int operate(int num1, char operator, int num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '*':
                return num1 * num2;
            case '-':
                return num1 - num2;
            default:
                return 0;
        }
    }
}
