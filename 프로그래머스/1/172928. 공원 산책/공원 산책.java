import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] twoDArray = new char[park.length][];
        int[] currentLocation = null;
        for (int i = 0; i < park.length; i++) {
            twoDArray[i] = park[i].toCharArray();
        }
        for(int i = 0; i < park.length; i ++){
            if(park[i].contains("S")) {
                currentLocation = new int[]{park[i].indexOf("S"), i};
            }
        }

        for(int i = 0; i < routes.length; i ++) {
            String direction = routes[i].split(" ")[0];
            int num = Integer.parseInt(routes[i].split(" ")[1]);
            int x = currentLocation[0];
            int y = currentLocation[1];
            switch(direction){
                case "E":
                    boolean flag1 = false;
                    for(int j = 1; j <= num; j ++){
                        if(x + num >= twoDArray[0].length){
                            flag1 = true;
                            break;
                        } else if (String.valueOf(twoDArray[y][x + j]).equals("X")){
                            flag1 = true;
                            break;
                        }
                    }
                    if(!flag1){
                        currentLocation[0] = x + num;
                    }
                    break;

                case "W":
                    boolean flag2 = false;
                    for(int j = 1; j <= num; j ++){
                        if(x - num < 0){
                            flag2 = true;
                            break;
                        } else if (String.valueOf(twoDArray[y][x - j]).equals("X")){
                            flag2 = true;
                            break;
                        }
                    }
                    if(!flag2){
                        currentLocation[0] = x - num;
                    }
                    break;
                case "N":
                    boolean flag3 = false;
                    for(int j = 1; j <= num; j ++){
                        if(y - num < 0){
                            flag3 = true;
                            break;
                        } else if (String.valueOf(twoDArray[y - j][x]).equals("X")){
                            flag3 = true;
                            break;
                        }
                    }
                    if(!flag3){
                        currentLocation[1] = y - num;
                    }
                    break;
                case "S":
                    boolean flag = false;
                    for(int j = 1; j <= num; j ++){
                        if(y + num >= twoDArray.length){
                            flag = true;
                            break;
                        } else if (String.valueOf(twoDArray[y + j][x]).equals("X")){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        currentLocation[1] = y + num;
                    }
                    break;
                    
            } 
        }
        int xy = currentLocation[0];
        currentLocation[0] = currentLocation[1];
        currentLocation[1] = xy;
        return currentLocation;
    }
}