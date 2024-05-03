import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	HashMap<String,Long> map = new HashMap<>();
	String str = br.readLine();
	StringTokenizer st = new StringTokenizer(str); 
	for(int i =0;i<N;++i) {
		String key = st.nextToken();
		long value = Long.parseLong(key);
		map.put(key, value);
	}
	StringBuilder sb = new StringBuilder();
	int M = Integer.parseInt(br.readLine());
	String str2 = br.readLine();
	StringTokenizer st2 = new StringTokenizer(str2);
	for(int i =0;i<M;++i) {
		String key = st2.nextToken();
		long value = Long.parseLong(key);
		try {
			if(map.get(key)==(value)) {
				sb.append(1).append("\n");
			}
		} catch (Exception e) {
			sb.append(0).append("\n");
		}
	}
	System.out.println(sb.toString());
}
}
