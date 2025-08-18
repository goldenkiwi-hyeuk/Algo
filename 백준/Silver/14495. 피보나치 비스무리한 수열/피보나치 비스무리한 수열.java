import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static long[] arr = new long[117];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        fibonachi(n);
        System.out.println(arr[n]);
    }

    private static long fibonachi(int n) {
        if (arr[n] != 0) return arr[n];
        arr[n] = fibonachi(n - 1) + fibonachi(n - 3);
        return arr[n];
    }
}
