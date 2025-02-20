import java.io.*;
import java.util.*;

class Main {
    static class Question {
        int deadLine;
        int noodles;

        public Question(int deadLine, int noodles) {
            this.deadLine = deadLine;
            this.noodles = noodles;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Question> questionList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxDeadLine = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Question question = new Question(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            questionList.add(question);
            maxDeadLine = Math.max(question.deadLine, maxDeadLine);
        }

        questionList.sort((a, b) -> b.deadLine - a.deadLine);

        int cupNoodles = 0;
        int index = 0;
        for (int deadLine = maxDeadLine; deadLine >= 1; deadLine--) {
            while (index < n && questionList.get(index).deadLine >= deadLine) {
                pq.offer(questionList.get(index).noodles);
                index++;
            }
            if (!pq.isEmpty()) {
                cupNoodles += pq.poll();
            }
        }

        System.out.println(cupNoodles);

    }
}