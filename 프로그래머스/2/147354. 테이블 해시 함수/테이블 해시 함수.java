import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer;
        List<Integer> sumList = new ArrayList();
        Arrays.sort(data, (a, b) -> {
            int result = Integer.compare(a[col-1], b[col-1]);
            if(result == 0) {
                return Integer.compare(b[0], a[0]);
            }
            return result;
        });

        for(int i = row_begin - 1; i <= row_end - 1; i ++) {
            int sum = 0;
            for(int j = 0; j < data[i].length; j ++) {
                sum += data[i][j] % (i + 1);
            }
            sumList.add(sum);
        }
        answer = sumList.get(0);
        for(int i = 1; i < sumList.size(); i++) {
            answer = answer ^ sumList.get(i);
        }

        return answer;
    }
}