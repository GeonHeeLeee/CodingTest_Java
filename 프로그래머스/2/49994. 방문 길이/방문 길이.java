import java.util.*;
class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet();
        String[] directions = dirs.split("");
        int curX = 0;
        int curY = 0;
        for(String dir : directions) {
            String oppoDir = "";
            if(dir.equals("U") && curY < 5) {
                visited.add(curX + "," + curY + dir);
                curY ++;
                oppoDir = "D";
            } else if(dir.equals("D") && curY > -5) {
                visited.add(curX + "," + curY + dir);
                curY --;
                oppoDir = "U";
            } else if(dir.equals("L") && curX > -5) {
                visited.add(curX + "," + curY + dir);
                curX --;
                oppoDir = "R";
            } else if(dir.equals("R") && curX < 5) {
                visited.add(curX + "," + curY + dir);
                curX ++;
                oppoDir = "L";
            }
            if(!oppoDir.equals("")){
                visited.add(curX + "," + curY + oppoDir);
            }

        }
        System.out.println(visited);
        return visited.size() / 2;
    }
}