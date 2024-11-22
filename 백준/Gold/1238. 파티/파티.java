import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int end, cost;

        Edge(){}

        Edge(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Edge>> edgeList = new ArrayList<>();
        List<List<Edge>> reverseEdgeList = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            edgeList.add(new ArrayList<>());
            reverseEdgeList.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeList.get(start).add(new Edge(end,cost));
            reverseEdgeList.get(end).add(new Edge(start,cost));
        }
        int[] dist = new int[N+1];
        int[] reverseDist = new int[N+1];
        int INF = 987654321;
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);
        dist[X] = 0;
        reverseDist[X] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.add(new Edge(X,0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(visited[e.end]){ continue; }
            visited[e.end] = true;
            for(Edge edge : edgeList.get(e.end)){
                if(dist[edge.end] > dist[e.end] + edge.cost){
                    dist[edge.end] = dist[e.end] + edge.cost;
                    pq.add(new Edge(edge.end, dist[edge.end]));
                }
            }
        }
        visited = new boolean[N+1];
        pq.add(new Edge(X,0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(visited[e.end]){ continue; }
            visited[e.end] = true;
            for(Edge edge : reverseEdgeList.get(e.end)){
                if(reverseDist[edge.end] > reverseDist[e.end] + edge.cost){
                    reverseDist[edge.end] = reverseDist[e.end] + edge.cost;
                    pq.add(new Edge(edge.end, reverseDist[edge.end]));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if(dist[i]+reverseDist[i]>max){
                max = dist[i]+reverseDist[i];
            }
        }
        System.out.println(max);
    }

}
