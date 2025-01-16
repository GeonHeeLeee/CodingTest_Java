import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
    
        if(b == 1) {
            System.out.println(a % c);
            return;
        }
    
        System.out.println(compute(a, b, c));
    }

    public static long compute(long a, long b, long c) {
        if(b == 1) {
            return a % c;
        }

        long answer = compute(a, b/2, c) % c;
        if(b % 2 == 1) {
            return (((answer % c) * (answer % c) % c) * (a % c)) % c;
        } else {
            return ((answer % c) * (answer % c) % c);
        }
    }
}
