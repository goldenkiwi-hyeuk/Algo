import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] parent;
    private static class Edge implements Comparable<Edge> {
        int start,end,cost;

        public Edge(){}

        public Edge(int start, int end, int cost) {
            this.start = start;
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
        N = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(start, end, cost));
        }
        int total = N;
        int ans = 0;
        while (!pq.isEmpty()) {
            if (total == 2){
                break;
            }
            Edge e = pq.poll();
            int startP = findParent(e.start);
            int endP = findParent(e.end);
            if (startP!=endP){
                parent[startP] = Math.min(startP, endP);
                parent[endP] = Math.min(startP, endP);
                total--;
                ans += e.cost;
            }
        }
        System.out.println(ans);
    }

    private static int findParent(int num){
        if (num == parent[num]) return num;
        return parent[num] = findParent(parent[num]);
    }
}
