import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(String s : skill.split("")) {
            sb.append(s + "|");
        }
        String skillOrder = sb.substring(0,sb.length()-1).toString();
        for(String s : skill_trees) {
            String[] skillTree = s.split("");
            StringBuilder inputOrder = new StringBuilder();
            for(String letter : skillTree) {
                if(letter.matches(skillOrder)) {
                    inputOrder.append(letter);
                }
            }
            if(skill.startsWith(inputOrder.toString())) {
                answer ++;
            }
        }
        
        return answer;
    }
}