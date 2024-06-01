import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for(int i=0; i<N;++i) {
			String site = sc.next();
			String pw = sc.next();
			map.put(site, pw);
		}
		for(int i=0; i<M;++i) {
			String site = sc.next();
			System.out.println(map.get(site));
		}
	}
}
