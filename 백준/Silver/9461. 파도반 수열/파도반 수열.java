import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; ++tc) {
			List<Long> list = new ArrayList<>();
			list.add((long)0);
			list.add((long)1);
			list.add((long)1);
			list.add((long)1);
			list.add((long)2);
			list.add((long)2);
			int n = Integer.parseInt(br.readLine());
			if(n<=5) {
				sb.append(list.get(n)).append("\n");
			} else {
				try {
					sb.append(list.get(n)).append("\n");
				} catch (Exception e) {
					while(list.size()!=n+1) {
						list.add(list.get(list.size()-1)+list.get(list.size()-5));
					}
					sb.append(list.get(n)).append("\n");
				}
			}
//			System.out.println(list.toString());
		}
		System.out.println(sb);
	}
}
