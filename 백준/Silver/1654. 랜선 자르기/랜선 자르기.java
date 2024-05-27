import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        
        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextLong();
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        long left = 1;
        long right = max;
        long result = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            for (long length : arr) {
                count += length / mid;
            }
            
            if (count >= N) {
                result = mid;  // 현재 mid 값이 가능하므로, 결과를 저장하고 더 큰 값을 탐색
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}
