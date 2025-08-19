import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Math.min(arr[0], Math.min(arr[1], arr[2]));
        for (int i = 0; i < 3; i++) {
            arr[i] = arr[i] - ans;
        }
        int next1 = 987654321;
        int next2 = Math.max(arr[0], Math.max(arr[1], arr[2]));
        int zeroCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i] != 0){
                if (arr[i] < next1){
                    next1 = arr[i];
                }
            } else {
                zeroCnt++;
            }
        }
        if (zeroCnt == 2){
            next1 = 0;
        } else if (zeroCnt == 3){
            next1 = 0;
            next2 = 0;
        }
        ans += next1/3;
        ans += next2/3;
        next1 %= 3;
        next2 %= 3;
        if (next1 + next2 >= 3){
            ans += 2;
        } else if (next1+next2 >= 1){
            ans += 1;
        }
        System.out.println(ans);
    }
}
