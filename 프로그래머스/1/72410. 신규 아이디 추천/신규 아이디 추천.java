class Solution {
    public String solution(String new_id) {

        String answer = new_id.toLowerCase().replaceAll("[^a-z0-9._-]", "").replaceAll("\\.+",".");
        System.out.println(answer);
        if(answer.charAt(answer.length() - 1) == '.' && answer.length() > 1) {
            answer = answer.substring(0, answer.length() - 1);
        }
        System.out.println(answer);
        if(answer.substring(0, 1).equals(".") && answer.length() > 1) {
            answer = answer.substring(1, answer.length());
        }
        if(answer.equals("") || answer.equals(".")) {
            answer = "a";
        }
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if(answer.substring(answer.length() - 1).equals(".")) {
                answer = answer.substring(0,answer.length() - 1);
            }
        }
        if(answer.length() <= 2) {
            String letter = answer.substring(answer.length() - 1, answer.length());
            while(answer.length() < 3) {
                answer+=letter;
            }
        }
        
        return answer;
    }
}