import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Edge{
        int start, end, cost;

        public Edge(){}

        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }
    public static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; ++t) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            List<Edge> edgeList = new ArrayList<>();
            for(int i = 0 ; i<W; ++i){
                str = br.readLine();
                st = new StringTokenizer(str);
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(start, end, cost));
                edgeList.add(new Edge(end, start, cost));
            }
            for (int i = 0; i<R; ++i){
                str = br.readLine();
                st = new StringTokenizer(str);
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken())*-1;
                edgeList.add(new Edge(start, end, cost));
            }
            boolean canDo = false;
                int[] dist = new int[N];
                Arrays.fill(dist, INF);
                out : for (int j = 0 ; j<N; ++j){
                    for (int k = 0 ; k<edgeList.size(); ++k){
                        Edge edge = edgeList.get(k);
                        if (dist[edge.end-1] > dist[edge.start-1]+edge.cost){
                            dist[edge.end-1] = dist[edge.start-1]+edge.cost;
                            if (j==N-1){
                                canDo = true;
                                break out;
                            }
                        }
                    }
                }
            
            if (canDo) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
