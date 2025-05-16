import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add((x+500)*10000+(y+500));
        }
        String str = br.readLine();
        int x = 500;
        int y = 500;
        for (int i = 0; i < K; i++) {
            int nx = x, ny = y;
            switch (str.charAt(i)) {
                case 'L':
                    nx--;
                    break;
                case 'R':
                    nx++;
                    break;
                case 'U':
                    ny++;
                    break;
                case 'D':
                    ny--;
                    break;
            }
            if (!set.contains(nx * 10000 + ny)) {
                x = nx;
                y = ny;
            }
        }
        System.out.println((x-500)+" "+(y-500));
    }
}
