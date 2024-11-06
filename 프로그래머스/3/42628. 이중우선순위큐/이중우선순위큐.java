import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> treeSet = new TreeSet();
        List<Integer> duplList = new ArrayList();
        for(int i = 0; i < operations.length; i ++) {
            String[] splitStr = operations[i].split(" ");
            String command = splitStr[0];
            int num = Integer.parseInt(splitStr[1]);

            if(command.equals("I")) {
                if(treeSet.contains(num)) {
                    duplList.add(num);
                } else {
                    treeSet.add(num);
                }
            } else {
                if(!treeSet.isEmpty()) {
                    int value;
                    if(num == 1) {
                        value = treeSet.last();
                        treeSet.remove(value);
                    } else {
                        value = treeSet.first();
                        treeSet.remove(value);
                    }
                    if(duplList.contains(value)) {
                        treeSet.add(value);
                    }
                }
            }
        }
        if(treeSet.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int max = treeSet.last();
            int min = treeSet.first();
            return new int[]{max, min};
        }

    }
}