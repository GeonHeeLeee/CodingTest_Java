import java.io.*;
import java.util.*;

class Main {
    static boolean[] isNotPrime;
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;
        List<Integer> inputList = new ArrayList<>();
        int max = 0;
        while (true) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                break;
            }
            inputList.add(input);
            max = Math.max(input, max);
        }
        isNotPrime = new boolean[max + 1];
        addPrimeNumbers(max);

        for (int num : inputList) {
            boolean isFound = false;
            for (int prime : primeList) {
                if (prime > num / 2) {
                    break;
                }

                if (!isNotPrime[num - prime]) {
                    System.out.println(num + " = " + prime + " + " + (num - prime));
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }

    }

    public static void addPrimeNumbers(int max) {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 3; i <= max; i += 2) {
            if (!isNotPrime[i]) {
                primeList.add(i);
            }
        }
    }
}