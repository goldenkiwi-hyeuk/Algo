import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        while(true){
            Set<Integer> set = new HashSet<Integer>();
            int ans = 0;
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }
            for (int i = 0; i < M; i++) {
                if (set.contains(Integer.parseInt(br.readLine()))) {
                    ans++;
                }
            }
            sb.append(ans).append("\n");
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0){
                break;
            } else {
                N = a;
                M = b;
            }
        }
        System.out.println(sb.toString());
    }
}
