import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		str = br.readLine();
		st = new StringTokenizer(str);
		int right = 0;
		int left = 1;
		for(int i=0; i<N;++i) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(right<trees[i]) {
				right = trees[i];
			}
		}
		int mid = 0;
		int beforeMid = 0;
		boolean isOk = true;
		while(left<=right) {
			isOk = false;
			mid = (left+right)/2;
			long get = 0;
			for(int i=0; i<N;++i) {
				if(mid<trees[i]) {
					get += (trees[i]-mid);
				}
			}
			if(get>=M) {
				isOk = true;
				beforeMid = mid;
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		if(isOk) {
			System.out.println(mid);
		} else {
			System.out.println(beforeMid);
		}
	}
}
