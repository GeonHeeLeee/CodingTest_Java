import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            String[] input = br.readLine().split(" ");
            String s = input[0];
            String t = input[1];
            int xIndex = s.indexOf("x");
            if(xIndex == -1) {
                xIndex = s.indexOf("X");
            }
            String letter = Character.toString(t.charAt(xIndex));
            if(letter.matches("[0-9]")) {
                answer.append(letter);
            } else {
                answer.append(letter.toUpperCase());
            }
        }
        System.out.print(answer.toString());
    }
}
