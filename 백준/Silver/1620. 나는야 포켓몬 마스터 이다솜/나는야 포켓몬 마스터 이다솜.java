import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer,String> diction = new HashMap<>();
		Map<String,Integer> diction2 = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N;++i) {
			str = br.readLine();
			diction.put(i, str);
			diction2.put(str, i);
		}
		for(int i=0; i<M;++i) {
			str = br.readLine();
			try {
				int num = Integer.parseInt(str);
				sb.append(diction.get(num)).append("\n");
			} catch (Exception e) {
				sb.append(diction2.get(str)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
