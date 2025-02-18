import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        List<List<Integer>> edgelist = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edgelist.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int total = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j<total-1;++j){
                int b = Integer.parseInt(st.nextToken());
                edgelist.get(b).add(a);
                arr[a]++;
                a = b;
            }
        }
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0){
                deq.addLast(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!deq.isEmpty()){
            int num = deq.pollFirst();
            list.add(num);
            for (int child : edgelist.get(num)) {
                arr[child]--;
                if (arr[child] == 0){
                    deq.addLast(child);
                }
            }
        }
        boolean isok = true;
        for (int i = 1; i<=N; ++i){
            if (arr[i]>0){
                isok = false;
                break;
            }
        }
        if (isok){
            StringBuilder sb = new StringBuilder();
            for (int i = list.size()-1; i>=0;--i){
                sb.append(list.get(i)).append("\n");
            }
            System.out.print(sb);
        } else {
            System.out.println(0);
        }
    }
}
