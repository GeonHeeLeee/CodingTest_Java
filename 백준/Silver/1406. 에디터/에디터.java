import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for(Character ch : input.toCharArray()) {
            leftStack.add(ch);
        }
        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case "L":
                    if(!leftStack.isEmpty()) {
                        rightStack.add(leftStack.pop());
                    }
                    break;
                case "D":
                    if(!rightStack.isEmpty()) {
                        leftStack.add(rightStack.pop());
                    }
                    break;
                case "P":
                    char addiChar = st.nextToken().charAt(0);
                    leftStack.add(addiChar);
                    break;
                case "B":
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            sb.append(leftStack.pop());
        }
        sb.reverse();
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
