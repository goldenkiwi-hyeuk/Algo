import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); 
        int A = Integer.parseInt(st.nextToken());
        int ans = 987654321;
        for(int i =0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int time = 0;
            if(K%(A*t) ==0){
                time = t*(K/(A*t))+s*(K/(A*t) - 1); 
            } else {
                time = t*(K/(A*t))+s*(K/(A*t)) + (K%(A*t))/A;
            }
            ans = Math.min(ans, time);
        }
        System.out.println(ans);
    }
}