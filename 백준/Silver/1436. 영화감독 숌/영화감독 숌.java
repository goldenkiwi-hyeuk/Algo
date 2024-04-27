import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int N = sc.nextInt();
		int num = 666;
		while(N>0) {
			String str = String.valueOf(num);
			if(str.contains("666")) {
				--N;
				if(N>0) {
					++num;
				}
				continue;
			} else {
				++num;
			}
		}
		System.out.println(num);
	}
}
