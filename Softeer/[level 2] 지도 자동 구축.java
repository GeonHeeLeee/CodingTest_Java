import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 0) {
            System.out.println(4);
            return;
        }
        if(n == 1) {
            System.out.println(9);
            return;
        }
        int start = 3;
        for(int i = 0; i < n-1; i ++) {
            start = (start * 2) - 1;
        }
        System.out.println((int) Math.pow(start, 2));
    }
}
