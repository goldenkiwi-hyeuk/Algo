import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr= new int[N];
		int[] cnt= new int[8001];
		int sum = 0;
		for(int i = 0; i<N;++i) {
			arr[i]= Integer.parseInt(br.readLine());
			sum += arr[i];
			++cnt[arr[i]+4000];
		}
		Arrays.sort(arr);
		int max = 0;
		for(int i=0; i<8001;++i) {
			if(cnt[i]>max) {
				max = cnt[i];
			}
		}
		int idx = 0;
		int check = 0;
		for(int i=0; i<8001;++i) {
			if(cnt[i]==max) {
				idx = i-4000;
				++check;
				if(check==2) {
					break;
				}
			}
		}
		// 산술평균 출력
		System.out.println(Math.round((double)sum/N));
		// 중앙값 출력
		System.out.println(arr[N/2]);
		// 최빈값 출력
		System.out.println(idx);
		// 범위 출력
		System.out.println(arr[N-1]-arr[0]);
	}
}
