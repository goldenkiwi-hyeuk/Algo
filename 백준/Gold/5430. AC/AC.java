import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; ++tc) {
			String control = br.readLine();
			Deque<Integer> deq = new ArrayDeque<>();
			boolean isleft = true;
			boolean noerr = true;
			str = br.readLine();
			int n = Integer.parseInt(str);
			str = br.readLine();
			str = str.substring(1, str.length() - 1);
			String[] strs = str.split(",");
			for (String str1 : strs) {
				try {
					deq.add(Integer.parseInt(str1));
				} catch (Exception e) {
				}
			}
			for(char c :control.toCharArray()) {
				if(c == 'R') {
					if(isleft) {
						isleft = false;
					} else {
						isleft = true;
					} 
				}
				if(c == 'D') {
					if(deq.size()!=0) {
						if(isleft) {
							deq.pollFirst();
						} else {
							deq.pollLast();
						}
					} else {
						noerr = false;
					}
				}
			}
			
			if(noerr) {
				if(deq.size()==0) {
					sb.append("[]");
				} else {
					if(isleft) {
						sb.append(deq.toString().replaceAll(" ",""));
					} else {
						int size = deq.size();
						sb.append("[");
						for(int i=0; i<size-1;++i) {
							sb.append(deq.pollLast()).append(",");
						}
						sb.append(deq.pollLast()).append("]");
					}
				}
			} else {
				sb.append("error");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
