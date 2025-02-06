import java.io.*;
import java.util.*;

public class Main {
    static int modifier = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long k = Long.parseLong(input[0]);
        long p = Long.parseLong(input[1]);
        long n = Long.parseLong(input[2]);

        long p10 = powMod(p, 10);
        long answer = (k * (powMod(p10, n) % modifier)) % modifier;
        
        System.out.println(answer);
    }

    public static long powMod(long base, long exp) {
        long result = 1;
        while(exp > 0) {
            if(exp % 2 == 1) {
                result = (result * base) % modifier;
            }
            base = (base * base) % modifier;
            exp = exp / 2;
        }
        return result;
    }
}
