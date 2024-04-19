import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int target = sc.nextInt();
	if(target == 1) {
		System.out.println(1);
	}else {
		int idx=2;
		int nextstep = 2;
		while(target>=nextstep) {
			nextstep+=((idx-1)*6);
			++idx;
		}
		System.out.println(idx-1);
	}
}
}
