import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] parent;
    static List<List<Integer>> childList = new ArrayList<>();;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            childList.add(new ArrayList<>());
        }
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parent[a]++;
            childList.get(b).add(a);
        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) {
                deq.add(i);
            }
        }
        while(!deq.isEmpty()) {
            int now = deq.poll();
            StringBuilder s = new StringBuilder();
            s.append(now).append(" ");
            sb.insert(0,s);
            for(int num : childList.get(now)) {
                parent[num]--;
                if (parent[num] == 0) {
                    deq.add(num);
                }
            }
        }
        System.out.println(sb);
    }
}
