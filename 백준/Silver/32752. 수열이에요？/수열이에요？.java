import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr2 = new int[R-L+1];
        for (int i = 0; i <= R-L; i++) {
            arr2[i] = arr1[i+L-1];
        }
        Arrays.sort(arr2);
        for (int i = 0; i <= R-L; i++) {
            arr1[i+L-1] = arr2[i];
        }

        boolean flag = false;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (arr1[i] < min) {
                flag = true;
            } else {
                min = arr1[i];
            }
        }

        if (flag){
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
