import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        int number = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i ++) {
            number = Integer.parseInt(br.readLine());
            answer = getMinPrimeNumber(number);
            System.out.println(answer + " " + (number - answer));
        }
        
    }

    public static int getMinPrimeNumber(int number) {
        int result = number;
        for(int i = number / 2; i >= 2; i --) {
            if(isPrimeNumber(i) && isPrimeNumber(number - i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static boolean isPrimeNumber(int number) {
        if(number == 2) {
            return true;
        }
        for(int i = 2; i < Math.sqrt(number) + 1; i ++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}