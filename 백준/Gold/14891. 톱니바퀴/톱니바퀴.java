import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> cogwheels = new HashMap<>();

        for (int i = 1; i <= 4; i++) {
            char[] input = br.readLine().toCharArray();
            cogwheels.put(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                cogwheels.get(i).add(input[j] - '0'); // 6 2
            }
        }

        int trial = Integer.parseInt(br.readLine());
        for (int t = 0; t < trial; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cogNum = Integer.parseInt(st.nextToken());
            boolean direction = Integer.parseInt(st.nextToken()) == 1; // 1:true:시계, -1:false:반시계계
            boolean[][] isRotate = new boolean[4][2];
            int curMag;
            int leftMag;
            int rightMag;
            int firstMag;
            int secondMag;
            int thirdMag;
            int fourthMag;
            isRotate[cogNum - 1][0] = true;
            isRotate[cogNum - 1][1] = direction;
            switch (cogNum) {
                case 1:
                    curMag = cogwheels.get(1).get(2);

                    for (int i = 2; i <= 4; i++) {
                        int nextMag = cogwheels.get(i).get(6);
                        if (curMag != nextMag && isRotate[i - 2][0]) {
                            isRotate[i - 1][0] = true;
                            isRotate[i - 1][1] = !isRotate[i - 2][1];
                        }
                        curMag = cogwheels.get(i).get(2);
                    }
                    break;
                case 2:
                    leftMag = cogwheels.get(2).get(6);
                    rightMag = cogwheels.get(2).get(2);

                    firstMag = cogwheels.get(1).get(2);
                    thirdMag = cogwheels.get(3).get(6);

                    if (leftMag != firstMag) {
                        isRotate[0][0] = true;
                        isRotate[0][1] = !isRotate[1][1];
                    }
                    if (rightMag != thirdMag) {
                        isRotate[2][0] = true;
                        isRotate[2][1] = !isRotate[1][1];
                    }
                    if (isRotate[2][0] && cogwheels.get(3).get(2) != cogwheels.get(4).get(6)) {
                        isRotate[3][0] = true;
                        isRotate[3][1] = !isRotate[2][1];
                    }
                    break;
                case 3:
                    leftMag = cogwheels.get(3).get(6);
                    rightMag = cogwheels.get(3).get(2);

                    secondMag = cogwheels.get(2).get(2);
                    fourthMag = cogwheels.get(4).get(6);

                    if (leftMag != secondMag) {
                        isRotate[1][0] = true;
                        isRotate[1][1] = !isRotate[2][1];
                    }
                    if (rightMag != fourthMag) {
                        isRotate[3][0] = true;
                        isRotate[3][1] = !isRotate[2][1];
                    }
                    if (isRotate[1][0] && cogwheels.get(1).get(2) != cogwheels.get(2).get(6)) {
                        isRotate[0][0] = true;
                        isRotate[0][1] = !isRotate[1][1];
                    }
                    break;
                case 4:
                    curMag = cogwheels.get(4).get(6);
                    for (int i = 3; i >= 1; i--) {
                        int nextMag = cogwheels.get(i).get(2);
                        if (curMag != nextMag && isRotate[i][0]) {
                            isRotate[i - 1][0] = true;
                            isRotate[i - 1][1] = !isRotate[i][1];
                        }
                        curMag = cogwheels.get(i).get(6);
                    }
                    break;
            }

            for (int i = 0; i < 4; i++) {
                if (isRotate[i][0]) {
                    List<Integer> current = cogwheels.get(i + 1);
                    if (isRotate[i][1]) {
                        current.add(0, current.remove(current.size() - 1));
                    } else {
                        current.add(current.remove(0));
                    }
                }
            }

        }

        int mul = 1;
        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            int current = cogwheels.get(i).get(0);
            if (current == 1) {
                answer += mul;
            }
            mul *= 2;
        }
        System.out.println(answer);
    }
}