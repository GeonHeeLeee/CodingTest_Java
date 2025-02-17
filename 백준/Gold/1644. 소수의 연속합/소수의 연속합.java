import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> primeList = new ArrayList<>();
        for (int num = 2; num <= n; num++) {
            if (isPrimeNumber(num)) {
                primeList.add(num);
            }
        }
        int answer = 0;
        int sum = 0;
        int first = 0;
        int last = first;

        while (first < primeList.size() && last < primeList.size()) {
            sum += primeList.get(last);
            if (sum >= n) {
                while (sum > n) {
                    sum -= primeList.get(first++);
                }
                if (sum == n) {
                    answer++;
                }
            }
            last++;
        }
        System.out.println(answer);

    }

    public static boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
