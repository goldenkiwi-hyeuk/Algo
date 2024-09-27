import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static boolean isok;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		cnt = 1;
		isok = false;
		go(A,B);
		if(isok){
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}
	public static void go(int A, int B) {
		if(B<A){
			return;
		}
		if(B==A){
			isok = true;
			return;
		}

		if(B%2==0){
			++cnt;
			go(A,B/2);
		}
		if(B%10==1){
			++cnt;
			go(A,B/10);
		}
	}
}
