import java.io.*;
import java.util.*;

class Main {
    static int l, c;
    static char[] letters;
    static Set<String> answers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        letters = new char[c];
        for (int i = 0; i < c; i++) {
            char letter = st.nextToken().charAt(0);
            letters[i] = letter;
        }
        Arrays.sort(letters);
        getCombinations(0, 0, 0, new StringBuilder());

        List<String> answerList = new ArrayList<>(answers);
        Collections.sort(answerList);
        for (String s : answerList) {
            System.out.println(s);
        }
    }

    public static void getCombinations(int idx, int vCount, int cCount, StringBuilder sb) {
        if (sb.length() == l) {
            if (cCount >= 1 && vCount >= 2) {
                answers.add(sb.toString());
            }
        }

        if (idx >= c) {
            return;
        }

        char curLetter = letters[idx];
        sb.append(curLetter);

        if (isConsonant(curLetter)) {
            getCombinations(idx + 1, vCount, cCount + 1, sb);
        } else {
            getCombinations(idx + 1, vCount + 1, cCount, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        getCombinations(idx + 1, vCount, cCount, sb);
    }

    public static boolean isConsonant(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}