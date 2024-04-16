import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int ans = 0;
	for(int i =0; i<=N;++i) {
		int sum = i;
		String str = Integer.toString(i);
		for(int j = 0; j<str.length();++j) {
			sum += (int) str.charAt(j)-48;
		}
		if(sum==N) {
			ans = i;
			break;
		}
	}
	System.out.println(ans);
}
}
