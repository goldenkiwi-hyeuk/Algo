import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int end, cost;

        public Edge() {
        }

        public Edge(int end, int cost) {
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
        int N = Integer.parseInt(br.readLine());
        List<List<Edge>> nodeList = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            nodeList.add(new ArrayList<Edge>());
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodeList.get(start).add(new Edge(end, cost));
        }
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());
        int[] dist = new int[N+1];
        Arrays.fill(dist, 987654321);
        dist[startPoint] = 0;
        boolean[] visited = new boolean[N+1];
        int[] prev = new int[N+1];
        prev[startPoint] = -1;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startPoint, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.end]) continue;
            visited[edge.end] = true;
            for (Edge e : nodeList.get(edge.end)) {
                if (dist[e.end] > dist[edge.end] + e.cost) {
                    dist[e.end] = dist[edge.end] + e.cost;
                    prev[e.end] = edge.end;
                    pq.add(new Edge(e.end, dist[edge.end]+e.cost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dist[endPoint]).append("\n");
        List<Integer> route = new ArrayList<>();
        int previdx = endPoint;
        while(previdx != -1){
            route.add(previdx);
            previdx = prev[previdx];
        }
        sb.append(route.size()).append("\n");
        for (int i=route.size()-1; i>=0; i--) {
            sb.append(route.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
