import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int k = 0;
        String num = br.readLine();
        Deque<Character> deq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int now = num.charAt(i) - '0';
            if (!deq.isEmpty()) {
                if (deq.peekLast() - '0' < now){
                    while (!deq.isEmpty() && deq.peekLast() - '0' < now && k<K){
                        ++k;
                        deq.pollLast();
                    }
                    deq.addLast(num.charAt(i));
                } else {
                    deq.addLast(num.charAt(i));
                }
            } else {
                deq.addLast(num.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(k!=K){
            deq.pollLast();
            ++k;
        }
        
        while (!deq.isEmpty()){
            sb.append(deq.pollFirst());
        }
        System.out.println(sb.toString());
    }
}
