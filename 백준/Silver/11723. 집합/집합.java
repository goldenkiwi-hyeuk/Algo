import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	Set<Integer> set = new HashSet<>();
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < N; ++i) {
		String str = sc.next();
		switch (str) {
		case "add": {
			set.add(sc.nextInt());
			break;
		}
		case "remove": {
			Integer data = sc.nextInt();
			if (set.contains(data)) {
				set.remove(data);
			}
			break;
		}
		case "check": {
			Integer data = sc.nextInt();
			if (set.contains(data)) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
			break;
		}
		case "toggle": {
			Integer data = sc.nextInt();
			if (set.contains(data)) {
				set.remove(data);
			} else {
				set.add(data);
			}
			break;
		}
		case "all": {
			for(int j =1; j<21;++j) {
				set.add(j);
			}
			break;
		}
		case "empty": {
			set.clear();
			break;
		}
		}
	}
	System.out.println(sb.toString());
}
}
