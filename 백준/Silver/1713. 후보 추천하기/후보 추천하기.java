import java.io.*;
import java.util.*;

class Main {

    static class Photo {
        int time;
        int index;
        int likes = 0;

        public Photo(int time, int index) {
            this.time = time;
            this.index = index;
            this.likes = 1;
        }

        public void likePhoto() {
            this.likes++;
        }

        public String toString() {
            return this.index + " ";
        }

        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null) {
                return false;
            }
            Photo photo = (Photo) o;
            return index == photo.index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int[] likes = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            likes[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Photo> people = new HashMap<>();
        PriorityQueue<Photo> candidates = new PriorityQueue<>((a, b) -> {
            int result = Integer.compare(a.likes, b.likes);
            if (result != 0) {
                return result;
            }
            return Integer.compare(a.time, b.time);
        });

        for (int time = 0; time < count; time++) {
            int person = likes[time];
            if (candidates.size() < n) {
                if (people.containsKey(person)) {
                    candidates.remove(people.get(person));
                    people.get(person).likePhoto();
                    candidates.add(people.get(person));
                } else {
                    Photo newPhoto = new Photo(time, person);
                    candidates.add(newPhoto);
                    people.put(person, newPhoto);
                }
            } else {
                if(people.containsKey(person)) {
                    candidates.remove(people.get(person));
                    people.get(person).likePhoto();
                    candidates.add(people.get(person));
                } else {
                    Photo removed = candidates.poll();
                    people.remove(removed.index);
                    Photo newPhoto = new Photo(time, person);
                    candidates.add(newPhoto);
                    people.put(person, newPhoto);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        while(!candidates.isEmpty()) {
            answer.add(candidates.poll().index);
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int person : answer) {
            sb.append(person).append(" ");
        }
        System.out.println(sb.toString());

    }
}