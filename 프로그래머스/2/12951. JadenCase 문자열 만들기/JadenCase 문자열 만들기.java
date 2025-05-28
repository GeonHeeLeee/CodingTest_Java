class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] splitString = s.split(" ", -1);

        for(String subString : splitString) {
            if(subString.isEmpty()) {
                answer.append(" ");
                continue;
            }
            String firstString = subString.substring(0,1);
            if(!firstString.matches("[0-9]")) {
                firstString = firstString.toUpperCase();
            }
            
            if(subString.length() == 1) {
                answer.append(firstString + " ");
            } else {
                String afterString = subString.substring(1).toLowerCase();
                answer.append(firstString + afterString + " ");  
            }
        }
        

        
        return answer.toString().substring(0, answer.length() - 1);
    }
}