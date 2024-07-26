import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, PriorityQueue<Music>> genreGroups = new HashMap<>();
        Map<String, Integer> genrePlaysGroup = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            Music music = new Music(i, play);
            
            genreGroups.putIfAbsent(genre, new PriorityQueue<>());
            genreGroups.get(genre).offer(music);
            
            int beforeTotalPlays = genrePlaysGroup.getOrDefault(genre, 0);
            genrePlaysGroup.put(genre, beforeTotalPlays + play);
        }
        
        List<Genre> genreList = new ArrayList<>();
        for(String genre : genrePlaysGroup.keySet()) {
            int totalPlays = genrePlaysGroup.get(genre);
            Genre genreObject = new Genre(genre, totalPlays);
            genreList.add(genreObject);
        }
        
        Collections.sort(genreList);
        
        for(Genre genre : genreList) {
            String genreName = genre.name;
            PriorityQueue<Music> musics = genreGroups.get(genreName);
            int cnt = 0;
            while(!musics.isEmpty() && cnt < 2) {
                result.add(musics.poll().index);
                cnt++;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public static class Music implements Comparable<Music> {
        int index;
        int plays;
        
        public Music(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Music o) {
            if(this.plays == o.plays) {
                return this.index - o.index;
            }
            return o.plays - this.plays;
        }
    }
    
    public static class Genre implements Comparable<Genre> {
        String name;
        int totalPlays;
        
        public Genre(String name, int totalPlays) {
            this.name = name;
            this.totalPlays = totalPlays;
        }
        
        @Override
        public int compareTo(Genre o) {
            return o.totalPlays - this.totalPlays;
        }
    }
}
