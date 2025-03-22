import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int[] los, int[] res) {
        int answer = 0;
        Map<Integer, Integer> students = new HashMap();
        for(int i = 1; i <= n; i ++) {
            students.put(i, 0);
        }
        for(int a : los) {
            students.put(a, -1);
        }
        for(int b : res) {
            students.put(b, students.get(b) + 1);
        }
        Arrays.sort(res);
        System.out.println(students);
        for(int stu : res) {
            if(students.get(stu) == 1) {
                if(stu != 1 && stu != n) {
                    if(students.get(stu - 1) < 0) {
                        students.put(stu - 1, students.get(stu - 1) + 1);
                    } else if(students.get(stu + 1) < 0) {
                        students.put(stu + 1, students.get(stu + 1) + 1);
                    }
                } else if(stu == 1) {
                    if(students.get(stu + 1) < 0) {
                        students.put(stu + 1, students.get(stu + 1) + 1);     
                    } 
                } else if(stu == n) {
                    if(students.get(stu - 1) < 0) {
                        students.put(stu - 1, students.get(stu - 1) + 1);
                    }
                }
            }
        }
        System.out.println(students);
        for(int stu : students.keySet()) {
            if(students.get(stu) >= 0) {
                answer ++;
            }
        }
        return answer;
    }
}