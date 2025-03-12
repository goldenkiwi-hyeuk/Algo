import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long min;
    static int num1,num2,num3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        min = Long.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int left = i+1;
            int right = N-1;
            while (left < right&& right<N) {
                long sum = (long)arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < Math.abs(min)) {
                    min = sum;
                    num1 = arr[i];
                    num2 = arr[left];
                    num3 = arr[right];
                }

                if (sum>0L){
                    right--;
                } else if (sum<0L){
                    left++;
                } else {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num1).append(" ").append(num2).append(" ").append(num3);
        System.out.println(sb);
    }
}
