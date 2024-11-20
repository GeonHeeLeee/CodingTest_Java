import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList();
        Map<String, Integer> playSum = new HashMap();
        List<Music> musicList = new ArrayList();

        for(int i = 0; i < plays.length; i++) {
            playSum.put(genres[i], playSum.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(genres[i], plays[i], i));
        }
        
        Collections.sort(musicList, (a, b) -> Integer.compare(b.play, a.play));
        List<Map.Entry<String, Integer>> genreList = new ArrayList(playSum.entrySet());
        Collections.sort(genreList, (a, b) -> Integer.compare(b.getValue(), a.getValue()));
        
        
        for(int i = 0; i < genreList.size(); i ++) {
            String genre = genreList.get(i).getKey();
            int count = 0;
            
            for(Music music : musicList) {
                if(music.genre.equals(genre) && !music.visited) {
                    answer.add(music.index);
                    count ++;
                    music.visited = true;
                }
                if(count >= 2) {
                    count = 0;
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class Music {
    public String genre;
    public int play;
    public int index;
    public boolean visited;
    
    public Music(String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
        this.visited = false;
    } 
}