import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int tc = 0 ; tc<T;++tc) {
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			list.add(0);
			list.add(1);
			list.add(2);
			list.add(4);
			for(int i = 4; i<=n;++i) {
				list.add(list.get(i-1)+list.get(i-2)+list.get(i-3));
			}
			sb.append(list.get(n)).append("\n");
		}
		System.out.println(sb);
	}
}
