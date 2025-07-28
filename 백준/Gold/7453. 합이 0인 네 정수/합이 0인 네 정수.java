import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] AB = new int[N*N];
        int[] CD = new int[N*N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j< N; ++j){
                AB[idx] = arr[i][0]+arr[j][1];
                CD[idx++] = arr[i][2]+arr[j][3];
            }
        }
        Arrays.sort(CD);

        long ans = 0;
        for(int num : AB){
            int target = num*-1;
            int upper = upperBound(CD, target);
            int lower = lowerBound(CD, target);
            ans += upper - lower;
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid]<=target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid]<target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
