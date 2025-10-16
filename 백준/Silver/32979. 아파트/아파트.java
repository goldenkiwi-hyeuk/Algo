import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N*2; i++) {
            deq.addLast(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j<b-1; ++j){
                deq.addLast(deq.pollFirst());
            }
            sb.append(deq.peekFirst()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
