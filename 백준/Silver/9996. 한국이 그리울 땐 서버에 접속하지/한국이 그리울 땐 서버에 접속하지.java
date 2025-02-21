import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        String first = pattern.split("\\*")[0];
        String second = pattern.split("\\*")[1];
        int length = first.length() + second.length();

        for(int i = 0; i < n; i ++) {
            String input = br.readLine();
            if(input.startsWith(first) && input.endsWith(second) && length <= input.length()) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}