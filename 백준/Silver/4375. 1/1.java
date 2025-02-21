import java.io.*;
import java.util.Scanner;
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            int num = 0;

            for(int i = 1; i <= n; i ++) {
                num = (num * 10 + 1) % n;
                if(num == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }
}