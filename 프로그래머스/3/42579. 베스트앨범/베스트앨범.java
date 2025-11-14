import java.util.*;

class Solution {
    private static class Genre implements Comparable<Genre>{
        String name;
        int plays;
        
        Genre(){}
        
        Genre(String name, int plays){
            this.name = name;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Genre o){
            return o.plays - this.plays;
        }
    }
    
    private static class Sing implements Comparable<Sing>{
        int idx;
        int plays;
        
        Sing(){}
        
        Sing(int idx, int plays){
            this.idx = idx;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Sing o){
            if(this.plays == o.plays){
                return this.idx - o.idx;
            }
            return o.plays - this.plays;
        }
    }
    
    public static int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> type = new HashMap<>();
        Map<String, PriorityQueue<Sing>> map = new HashMap<>();
        for(int i = 0; i<genres.length; ++i){
            if(type.containsKey(genres[i])){
                // 장르 조회가 된다면
                // 해당 장르에 재생 빈도 최신화
                type.put(genres[i], type.get(genres[i])+plays[i]);
                // 해당 장르 pq에 Sing 객체 생성및 추가
                PriorityQueue<Sing> pq = map.get(genres[i]);
                pq.add(new Sing(i, plays[i]));
                map.put(genres[i], pq);
            } else {
                // 장르 조회가 안된다면
                // 해당 장르 추가
                type.put(genres[i], plays[i]);
                // 해당 장르 pq생성 후 Sing 객체 생성 및 추가
                PriorityQueue<Sing> pq = new PriorityQueue<>();
                pq.add(new Sing(i, plays[i]));
                map.put(genres[i], pq);
            }
        }
        // 가장 많이 조회된 장르를 찾기 위한 genrepq생성
        PriorityQueue<Genre> genrepq = new PriorityQueue<>();
        for(String genre : type.keySet()){
            genrepq.add(new Genre(genre, type.get(genre)));
        }
        
        // 앨범을 담을 list
        List<Integer> list = new ArrayList<>();
        while(!genrepq.isEmpty()){
            // genrepq내부에서 가장 많이 조회된 장르를 추출
            Genre genre = genrepq.poll();
            // 해당 장르의 노래 pq 불러와서
            PriorityQueue<Sing> pq = map.get(genre.name);
            // 최대 2개씩 빼내 list에 넣기
            if(pq.size()>=2){
                Sing sing = pq.poll();
                list.add(sing.idx);
                sing = pq.poll();
                list.add(sing.idx);
            } else {
                Sing sing = pq.poll();
                list.add(sing.idx);
            }
        }
        
        //  list값을 answer에 넣기
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); ++i){
            answer[i] = list.get(i);
        }
        return answer;
    }
}