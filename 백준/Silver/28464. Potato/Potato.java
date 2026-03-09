import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            minpq.add(num);
            maxpq.add(num);
        }

        long min = 0;
        long max = 0;
        int cnt = 0;
        while(true){
            if (cnt%2 == 0){
                max += maxpq.poll();
            } else {
                min += minpq.poll();
            }
            ++cnt;
            if (cnt == N){
                break;
            }
        }
        System.out.println(min + " " + max);
    }
}
