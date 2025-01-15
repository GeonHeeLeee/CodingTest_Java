import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Map<Character, Integer> letterMap = new HashMap<>();
        for(char letter : input.toCharArray()) {
            letterMap.put(letter, letterMap.getOrDefault(letter, 0) + 1);
        }
        for(char idx = 'a'; idx <= 'z'; idx ++) {
            System.out.print(letterMap.getOrDefault(idx, 0) + " ");
        }
    }
}
