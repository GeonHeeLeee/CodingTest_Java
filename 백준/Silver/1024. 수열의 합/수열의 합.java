import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken()); // 입력된 n 값
            int l = Integer.parseInt(st.nextToken()); // 최소 길이 l 값
            
            // 길이 i를 l부터 시작하여 최대 100까지 시도
            for (int i = l; i <= 100; i++) {
                // k 계산: 연속된 정수의 시작 값
                int k = (2 * n - i * (i - 1)) / (2 * i);
                
                // 조건: k가 0 이상이고 정확히 합을 만족하는지 확인
                if (k >= 0 && (k * 2 + i - 1) * i / 2 == n) {
                    for (int j = 0; j < i; j++) {
                        System.out.print((k + j) + " "); // 연속된 숫자 출력
                    }
                    return; // 결과를 출력한 후 종료
                }
            }
            
            // 조건에 맞는 연속된 숫자 배열을 찾지 못한 경우
            System.out.print(-1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
