import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b == 0){
                if (set.contains(a)){
                    set.remove(a);
                } else {
                    ++cnt;
                }
            } else {
                if (set.contains(a)){
                    ++cnt;
                } else {
                    set.add(a);
                }
            }
        }
        cnt += set.size();
        System.out.println(cnt);
    }
}
