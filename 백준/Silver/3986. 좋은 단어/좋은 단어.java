import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int trial = 0; trial < n; trial ++) {
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for(char letter : input) {
                if(stack.isEmpty()) {
                    stack.push(letter);
                } else {
                    if(stack.peek().equals(letter)) {
                        stack.pop();
                    } else {
                        stack.push(letter);
                    }
                }
            }
            if(stack.isEmpty()) {
                answer ++;
            }
        }
        System.out.println(answer);
    }
}
