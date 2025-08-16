import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        int num = 987654321;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if (A == 1){
                int a = Integer.parseInt(st.nextToken());
                deq.addLast(a);
                if (max<deq.size()){
                    max = deq.size();
                    num = deq.peekLast();
                } else if (max == deq.size()){
                    num = Math.min(num, deq.peekLast());
                }
            } else {
                deq.pollFirst();
            }
        }
        System.out.println(max+" "+num);
    }
}
