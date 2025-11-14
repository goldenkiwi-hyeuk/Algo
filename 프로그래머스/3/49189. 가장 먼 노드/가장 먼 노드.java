import java.util.*;

class Solution {
    // 기본아이디어 : 다익스트라
    private static class Edge implements Comparable<Edge>{
        int end;
        int cost;
        
        Edge(){}
        
        Edge(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }
    
    private static List<List<Edge>> edgeList;
    
    public int solution(int n, int[][] edge) {
        
        // 다익스트라 구현을 위한 edgeList 기초 셋팅
        edgeList = new ArrayList<>();
        for(int i = 0; i<=n; ++i){
            edgeList.add(new ArrayList<Edge>());
        }
        
        // 연결된 부분 값을 1로 갱신
        for(int[] connect : edge){
            int start = connect[0];
            int end = connect[1];
            edgeList.get(start).add(new Edge(end,1));
            edgeList.get(end).add(new Edge(start,1));
        }
        
        // 방문처리를 위한 boolean 배열
        boolean[] visited = new boolean[n+1];
        
        // Edge pq 생성 및 시작점(1)으로가는 비용이 0인 Edge 기본값으로 넣기
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,0));
        
        // 최종적으로 체크할 1번과의 거리배열
        int[] dist = new int[n+1];
        int INF = 987654321;
        Arrays.fill(dist,INF);
        dist[1] = 0;
        
        // 다익스트라 실행
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            // 이미 방문한 노드는 패스
            if(visited[cur.end]){
                continue;
            }
            // 방문처리
            visited[cur.end] = true;
            
            // 새롭게 방문가능한 Edge를 탐색
            for(Edge next : edgeList.get(cur.end)){
                // 거리가 갱신된다면 dist거리 갱신 및 pq에 Edge넣기
                if(dist[next.end] > dist[cur.end] + next.cost){
                    dist[next.end] = dist[cur.end] + next.cost;
                    pq.add(new Edge(next.end, dist[next.end]));
                }
            }
        }

        int maxDist = -1;
        int answer = 1;
        for(int i = 2; i<=n; ++i){
            if(dist[i]> maxDist){
                answer = 1;
                maxDist = dist[i]; 
            } else if(dist[i] ==  maxDist){
                ++answer;
            }
        }
        
        return answer;
    }
}
