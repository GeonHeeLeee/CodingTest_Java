import java.util.*;
import java.util.stream.*;
class Song {
    int index;
    int play;
    
    public Song(int index, int play) {
        this.index = index;
        this.play = play;
    }
}

class Genre {
    String name;
    int plays;
    
    public Genre(String name, int plays) {
        this.name = name;
        this.plays = plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap();
        Map<String, List<Song>> songMap = new HashMap();
        
        for(int i = 0; i < genres.length; i ++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            Song song = new Song(i, plays[i]);
            if(!songMap.containsKey(genres[i])) {
                songMap.put(genres[i], new ArrayList<>());
            }
            songMap.get(genres[i]).add(song);
        }
        
        List<Genre> genreList = new ArrayList<>();
        for(String genre : genreMap.keySet()) {
            genreList.add(new Genre(genre, genreMap.get(genre)));
        }
        
        Collections.sort(genreList, (a,b) -> Integer.compare(b.plays, a.plays));
        
        for(Genre genre : genreList) {
            List<Song> songList = songMap.get(genre.name);
            Collections.sort(songList, (a,b) -> {
                int result = Integer.compare(b.play, a.play);
                if(result != 0) {
                    return result;
                }
                return Integer.compare(a.index, b.index);
            });
            if(songList.size() > 1) {
                answer.add(songList.get(0).index);
                answer.add(songList.get(1).index);
            } else {
                answer.add(songList.get(0).index);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}