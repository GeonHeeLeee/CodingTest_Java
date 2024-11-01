import java.util.*;
import java.time.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Deque<String[]> stack = new ArrayDeque<>();
        
        Arrays.sort(plans, Comparator.comparing(a -> convertToInt(a[1])));
        
        for (int i = 0; i < plans.length; i++) {
            String[] plan = plans[i];
            String course = plan[0];
            int startTime = convertToInt(plan[1]);
            int duration = Integer.parseInt(plan[2]);
            int endTime = startTime + duration;
            
            if (i + 1 < plans.length) {
                int nextStartTime = convertToInt(plans[i + 1][1]);
                
                if (endTime <= nextStartTime) {
                    answer.add(course);
                    
                    while (!stack.isEmpty()) {
                        String[] pausedTask = stack.pop();
                        String pausedCourse = pausedTask[0];
                        int remainingTime = Integer.parseInt(pausedTask[1]);
  
                        endTime += remainingTime;
                        
                        if (endTime <= nextStartTime) {
                            answer.add(pausedCourse);
                        } else {
                            stack.push(new String[]{pausedCourse, String.valueOf(endTime - nextStartTime)});
                            break;
                        }
                    }
                } else {
                    stack.push(new String[]{course, String.valueOf(endTime - nextStartTime)});
                }
            } else {
                answer.add(course);
            }
        }
        
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }
        
        return answer.toArray(new String[0]);
    }
    
    public int convertToInt(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}
