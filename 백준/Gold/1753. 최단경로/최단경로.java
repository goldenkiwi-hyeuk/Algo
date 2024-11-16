import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 987654321;

    static class Edge implements Comparable<Edge> {

        int end, cost;

        Edge() {
        }

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<ArrayList<Edge>> node = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            node.add(new ArrayList<>());
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<E ; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            node.get(s).add(new Edge(e,c));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K,0));
        int[] dist = new int[V+1];
        boolean[] visited = new boolean[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            visited[edge.end] = true;
            for(int i=0 ; i<node.get(edge.end).size() ; i++){
                int end = node.get(edge.end).get(i).end;
                int cost = node.get(edge.end).get(i).cost;
                if(!visited[end]){
                    if(dist[end]>dist[edge.end]+cost){
                        dist[end] = dist[edge.end]+cost;
                        pq.add(new Edge(end,dist[end]));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<dist.length ; i++){
            if(dist[i]!=INF){
                sb.append(dist[i]).append("\n");    
            } else {
                sb.append("INF").append("\n");
            }
        }
        System.out.println(sb);
    }
}
