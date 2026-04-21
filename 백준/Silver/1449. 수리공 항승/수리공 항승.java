import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        boolean flag = true;
        while(!pq.isEmpty()){
            ++cnt;
            double start = pq.poll()-0.5;
            double end = start + L;
            while(!pq.isEmpty()&&pq.peek()<=end){
                pq.poll();
            }
        }
        System.out.println(cnt);
    }
}
