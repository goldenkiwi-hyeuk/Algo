import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(str);
		for (int tc = 0; tc < T; ++tc) {
			str = br.readLine();
			int N = Integer.parseInt(str);
			Map<String,List<String>> map = new HashMap();	
			for(int i=0;i<N;++i) {
				str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				String item  = st.nextToken();
				String type  = st.nextToken();
				if(map.containsKey(type)) {
					List<String> list = map.get(type);
					list.add(item);
					map.put(type, list);
				} else {
					List<String> list = new ArrayList<>();
					list.add(item);
					map.put(type, list);
				}
			}
			if(map.isEmpty()) {
				sb.append(0).append("\n");
			} else {
				int cnt = 1;
				for( String strKey : map.keySet() ){
					cnt *= (map.get(strKey).size()+1);
				}
				sb.append(cnt-1).append("\n");
			}
		}
		System.out.println(sb);
	}
}
