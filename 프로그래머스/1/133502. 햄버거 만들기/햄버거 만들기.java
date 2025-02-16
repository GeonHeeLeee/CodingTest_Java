class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ingredient.length; i ++) {
            sb.append(String.valueOf(ingredient[i]));
            if(sb.length() >= 4) {
                if(sb.substring(sb.length() - 4).equals("1231")){
                    sb.delete(sb.length() - 4, sb.length());
                    answer ++;
                }
            }
        }

        return answer;
    }
}