class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        divideAndConquer(answer, arr, arr.length, 0, 0);
        return answer;
    }
    void divideAndConquer(int[] answer, int[][] arr, int length, int x, int y) {
        if(length == 1) {
          if(arr[y][x] == 1) {
              answer[1] += 1;
          } else {
              answer[0] += 1;
          }
            return;
        }
        boolean flag = true;
        int firstInt = arr[y][x];
        for(int i = y; i < y + length; i ++) {
            for(int j = x; j < x + length; j ++) {
                if(arr[i][j] != firstInt) {
                    flag = false;
                    divideAndConquer(answer, arr, length/2, x, y);
                    divideAndConquer(answer, arr, length/2, x + length/2, y);
                    divideAndConquer(answer, arr, length/2, x, y + length/2);
                    divideAndConquer(answer, arr, length/2, x + length/2, y+length/2);
                    return;
                }
            }
        }
        if(flag) {
            if(firstInt == 1) {
                answer[1] += 1;
            } else {
                answer[0] += 1;
            }
            return;
        }
    }
}