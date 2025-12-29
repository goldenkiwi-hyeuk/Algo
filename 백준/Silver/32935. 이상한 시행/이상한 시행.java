import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = 0;
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            total += num;
            pq.add(num);
        }

        while (true) {
            if (total*-1>pq.peek()){
                long num = pq.poll();
                pq.add(total*-1);
                total = num*-1;
            } else {
                break;
            }
        }
        System.out.println(total);
    }

}
