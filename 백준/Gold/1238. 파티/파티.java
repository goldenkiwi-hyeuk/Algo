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
        for(int i = 0; i <= N; i++){
            edgeList.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeList.get(start).add(new Edge(end,cost));
        }
        int[][] dist = new int[N+1][N+1];
        int INF = 987654321;
        Arrays.fill(dist[0], INF);
        for (int i = 1; i <= N; i++){
            Arrays.fill(dist[i], INF);
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N+1];
            dist[i][i] = 0;
            pq.add(new Edge(i,0));
            while (!pq.isEmpty()){
                Edge edge = pq.poll();
                if (visited[edge.end]){ continue; }
                visited[edge.end] = true;
                for (Edge e : edgeList.get(edge.end)){
                    if(dist[i][e.end]>dist[i][edge.end]+e.cost){
                        dist[i][e.end] = dist[i][edge.end]+e.cost;
                        pq.add(new Edge(e.end,dist[i][e.end]));
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if(dist[i][X]+dist[X][i]>max){
                max = dist[i][X]+dist[X][i];
            }
        }
        System.out.println(max);
    }

}
