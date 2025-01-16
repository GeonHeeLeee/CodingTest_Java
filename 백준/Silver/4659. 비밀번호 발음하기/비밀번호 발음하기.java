import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine();
            if(input.equals("end")) {
                return;
            }
            boolean firstCondition = false;
            boolean secondCondition = true;
            boolean thirdCondition = true;

            int consonantCount = 0;
            int vowelCount = 0;
            char beforeLetter = 'A';
            for(char letter : input.toCharArray()) {
                if(isVowel(letter)) {
                    firstCondition = true;
                    vowelCount ++;
                    consonantCount = 0;
                    if(vowelCount == 3) {
                        firstCondition = false;
                        break;
                    }
                }
                if(!isVowel(letter)) {
                    consonantCount ++;
                    vowelCount = 0;
                    if(consonantCount == 3) {
                        secondCondition = false;
                        break;
                    }
                }
                if(beforeLetter == letter && (beforeLetter != 'e' && beforeLetter != 'o')) {
                    thirdCondition = false;
                    break;
                }
                beforeLetter = letter;
            }
            if(firstCondition && secondCondition && thirdCondition) {
                System.out.println("<"+input+">" + " is acceptable.");
            } else {
                System.out.println("<"+input+">" + " is not acceptable.");
            }
        }
    }

    public static boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter =='u';
    }
}
