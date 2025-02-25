import java.io.*;
import java.util.*;

class Main {
    static int l, c;
    static char[] letters;
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        letters = new char[c];

        for (int i = 0; i < c; i++) {
            letters[i] = st.nextToken().charAt(0);

        }

        Arrays.sort(letters);
        dfs(0, 0, 0, new StringBuilder());
        for (String s : answer) {
            System.out.println(s);
        }
    }

    public static void dfs(int index, int vowels, int consonants, StringBuilder sb) {
        if (sb.length() == l) {
            if (vowels >= 1 && consonants >= 2) {
                answer.add(sb.toString());
            }
            return;
        }

        for (int i = index; i < c; i++) {
            sb.append(letters[i]);
            if (isVowel(letters[i])) {
                dfs(i + 1, vowels + 1, consonants, sb);
            } else {
                dfs(i + 1, vowels, consonants + 1, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}