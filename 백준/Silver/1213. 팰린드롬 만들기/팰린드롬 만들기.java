import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> letterMap = new TreeMap<>();
        String input = br.readLine();
        for(char letter : input.toCharArray()) {
            letterMap.put(letter, letterMap.getOrDefault(letter, 0) + 1);
        }

        int oddCount = 0;
        char oddChar = 0;

        for(char letter : letterMap.keySet()) {
            if(letterMap.get(letter) % 2 != 0) {
                oddChar = letter;
                oddCount ++;
            }
        }

        if((input.length() % 2 != 0 && oddCount > 1) || (input.length() % 2 == 0 && oddCount != 0)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder half = new StringBuilder();
        for (char letter : letterMap.keySet()) {
            int count = letterMap.get(letter) / 2;
            for (int i = 0; i < count; i++) {
                half.append(letter);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half);
        if (oddCount == 1) {
            result.append(oddChar);
        }
        result.append(half.reverse());

        System.out.println(result.toString());
    }
}
