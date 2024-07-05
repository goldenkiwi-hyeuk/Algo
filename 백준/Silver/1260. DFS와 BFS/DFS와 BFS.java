import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static PriorityQueue<Integer>[] pqsD;
    static boolean visitD[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        pqsD = new PriorityQueue[N+1];
        for(int i=1;i<=N;++i){
            pqsD[i] = new PriorityQueue<Integer>();
        }
        for(int i=0;i<M;++i){
            str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pqsD[a].add(b);
            pqsD[b].add(a);
        }
        sb = new StringBuilder();
        visitD = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        boolean visitB[] = new boolean[N+1];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(V);
        while(!que.isEmpty()){
            int number = que.poll();
            if(!visitB[number]){
                visitB[number] = true;
                sb.append(number).append(" ");
                while(!pqsD[number].isEmpty()){
                    que.add(pqsD[number].poll());
                }
            }
        }
        System.out.print(sb);
    }

    public static void dfs(int V){
        if(visitD[V]==true){
            return;
        }
        visitD[V] = true;
        sb.append(V).append(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!pqsD[V].isEmpty()){
            int num = pqsD[V].poll();
            dfs(num);
            pq.add(num);
        }
        pqsD[V] = pq;
    }
}
