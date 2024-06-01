import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numbers = br.readLine();
		StringTokenizer st1 = new StringTokenizer(numbers);
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		HashMap<String, String> map = new HashMap<>();
		for(int i = 0; i<N ;++i) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String site = st.nextToken();
			String pw = st.nextToken();
			map.put(site, pw);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M ;++i) {
			String site = br.readLine();
			sb.append(map.get(site)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
