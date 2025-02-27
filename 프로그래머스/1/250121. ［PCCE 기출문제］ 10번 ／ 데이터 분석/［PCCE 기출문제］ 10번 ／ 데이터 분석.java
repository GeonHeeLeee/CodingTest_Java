import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList();
        for(int i = 0; i < data.length; i ++) {
            if(ext.equals("code") && data[i][0] < val_ext) {
                answer.add(data[i]);
            } else if(ext.equals("date") && data[i][1] < val_ext) {
                answer.add(data[i]);
            } else if(ext.equals("maximum") && data[i][2] < val_ext) {
                answer.add(data[i]);
            } else if(ext.equals("remain") && data[i][3] < val_ext) {
                answer.add(data[i]);
            }
        }
        

        // 정렬 기준에 따른 정렬 수행
        Comparator<int[]> comparator = null;

        if (sort_by.equals("code")) {
            comparator = (a, b) -> Integer.compare(a[0], b[0]);
        } else if (sort_by.equals("date")) {
            comparator = (a, b) -> Integer.compare(a[1], b[1]);
        } else if (sort_by.equals("maximum")) {
            comparator = (a, b) -> Integer.compare(a[2], b[2]);
        } else if (sort_by.equals("remain")) {
            comparator = (a, b) -> Integer.compare(a[3], b[3]);
        }

        if (comparator != null) {
            Collections.sort(answer, comparator);
        }
        return answer.toArray(new int[answer.size()][]);
    }
}