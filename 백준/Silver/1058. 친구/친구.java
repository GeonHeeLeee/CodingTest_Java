import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] == 'Y') {
                    if (!visited[j]) {
                        visited[j] = true;
                        count++;
                    }
                    for (int k = 0; k < n; k++) {
                        if (k != i && matrix[j][k] == 'Y' && !visited[k]) {
                            visited[k] = true;
                            count++;
                        }
                    }
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
