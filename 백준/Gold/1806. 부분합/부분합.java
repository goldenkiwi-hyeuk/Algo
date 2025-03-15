import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int ans = 987654321;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int total = arr[0];
        while(right<N&&left<N){
            if (total >=S){
                if (ans > right-left+1){
                    ans = right-left+1;
                }
                total -= arr[left];
                ++left;
                continue;
            }

            if (left>right){
                right++;
                continue;
            }

            if (total < S){
                right++;
                if(right<N){
                    total += arr[right];
                }
            }
        }
        if (ans == 987654321){
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
