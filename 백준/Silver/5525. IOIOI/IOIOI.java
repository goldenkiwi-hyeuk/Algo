import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		boolean checkI = true;
		int level = 0 ; 
		int answer = 0;
		int idx = 0;
		for(int i = 0; i<M;++i) {
			if(checkI) {
				if(S.charAt(i)=='I') {
					++idx;
					checkI = false;
				} else {
					idx = 0;
					if(level>=N) {
						answer += level + 1 - N;
					}
					level = 0;
				}
				if(idx == 3) {
					idx = 1;
					++level;
				}
			} else {
				if(S.charAt(i)=='O') {
					++idx;
					checkI = true;
				} else {
					idx = 1;
					if(level>=N) {
						answer += level + 1 - N;
					}
					level = 0;
				}
			}
//			System.out.println("level : "+level+", idx : "+idx+", answer : "+answer);
		}
		if(level >= N ) {
			answer += level + 1 - N;
		}
		System.out.println(answer);
	}
}
