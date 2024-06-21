import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		list.add(0);
		int idx = 0;
		while (idx != n) {
			++idx;
			if (Math.sqrt(idx) % 1 == 0) {
				list.add(1);
			} else {
				int value = list.get(1) + list.get(idx - 1);
				for(int i = 2; i<=Math.sqrt(idx);++i) {
					value = Math.min(value, list.get(idx-i*i)+1);
				}
				list.add(value);
			}
		}
		System.out.println(list.get(n));
	}
}
