import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int end, cost;

        public Edge() {}

        public Edge(int end, int cost) {
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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, cost));
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if ( edge.end == end ){
                break;
            }

            if (dist[edge.end] < edge.cost) {
                continue;
            }
            for(int i =0 ; i<graph.get(edge.end).size(); i++){
                Edge nextedge = graph.get(edge.end).get(i);
                if(dist[nextedge.end] > dist[edge.end] + nextedge.cost){
                    dist[nextedge.end] = dist[edge.end] + nextedge.cost;
                    pq.add(new Edge(nextedge.end, dist[nextedge.end]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}
