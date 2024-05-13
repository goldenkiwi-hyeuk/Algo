import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N;++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int K = (int) Math.round((double)N/100*15);
		int cnt = 0 ;
		int sum = 0 ;
		for(int i = K;i<N-K;++i) {
			++cnt;
			sum+=arr[i];
		}
		int ans = (int) Math.round((double)sum/cnt);
		System.out.println(ans);
	}
}
