import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		if(N<=2) {
			System.out.println(list.get(N));
		} else {
			int idx = 2;
			while(idx!=N) {
				list.add((list.get(idx-1)+list.get(idx))%10007);
				++idx;
			}
			System.out.println(list.get(N)%10007);
		}
	}
}
