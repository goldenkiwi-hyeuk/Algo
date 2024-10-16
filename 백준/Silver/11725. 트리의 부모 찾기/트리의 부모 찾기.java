import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> edges= new HashMap<Integer, List<Integer>>();
        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(edges.containsKey(a)){
                edges.get(a).add(b);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                edges.put(a,list);
            }
            if(edges.containsKey(b)){
                edges.get(b).add(a);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                edges.put(b,list);
            }
        }
        int[] arr = new int[N+1];
        arr[1] = N+1;
        Deque<Integer> deq = new ArrayDeque<>();
        deq.push(1);
        while(!deq.isEmpty()){
            int cur = deq.poll();
            List<Integer> list = edges.get(cur);
            for(int node : list){
                if(arr[node]==0){
                    arr[node] = cur;
                    deq.push(node);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
