import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		int cnt = 0;
		for(int i = 0 ; i<N;++i) {
			set.add(sc.next());
		}
		for(int i = 0; i<M;++i ) {
			String str = sc.next();
			if(set.contains(str)) {
				++cnt;
				list.add(str);
			}
		}
		System.out.println(cnt);
		list.sort(Comparator.naturalOrder());
		for(String name : list) {
			System.out.println(name);
		}
	}
}
