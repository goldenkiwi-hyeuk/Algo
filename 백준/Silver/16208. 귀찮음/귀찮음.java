import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static long totalCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        totalCost = 0;
        checkCost(0, N-1);
        System.out.println(totalCost);
    }

    private static void checkCost(int idx1, int idx2) {
        if (idx1 == idx2){
            return;
        }
        int mid = (idx1+idx2)/2;
        long cost1 = 0;
        for(int i = idx1; i<=mid; ++i){
            cost1 += arr[i];
        }
        long cost2 = 0;
        for(int i = mid+1; i<=idx2; ++i){
            cost2 += arr[i];
        }
        totalCost +=  (cost1 * cost2);
        checkCost(idx1, mid);
        checkCost(mid+1, idx2);
    }
}
