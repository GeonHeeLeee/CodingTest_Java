import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> queue = new TreeSet();
        List<Integer> dupList = new ArrayList();
        for(String operation : operations) {
            String command = operation.split(" ")[0];
            int number = Integer.parseInt(operation.split(" ")[1]);
            if(command.equals("I")) {
                if(queue.contains(number)) {
                    dupList.add(number);
                } else {
                    queue.add(number);
                }
            } else if(command.equals("D") && !queue.isEmpty()) {
                if(number == -1) {
                    if(dupList.contains(queue.first())) {
                        dupList.remove(queue.first());
                    } else if(!queue.isEmpty()) {
                        queue.remove(queue.first());
                    }
                } else {
                    if(dupList.contains(queue.last())) {
                        dupList.remove(queue.last());
                    } else if(!queue.isEmpty()) {
                        queue.remove(queue.last());
                    }
                }
            }
        }
        if(!queue.isEmpty()) {
            return new int[]{queue.last(), queue.first()};
        } else {
            return new int[]{0, 0};
        }
        
    }
}