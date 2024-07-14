import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	String str = sc.next();
	int bigdata = 0;
	int security = 0;
	int idx = 0;
	while(bigdata+security<N) {
		if(str.charAt(idx) == 'b') {
			++bigdata;
			idx+=7;
		} else if (str.charAt(idx) == 's') {
			++security;
			idx+=8;
		}
	}
	if(bigdata>security) {
		System.out.println("bigdata?");
	}else if(bigdata<security) {
		System.out.println("security!");
	} else {
		System.out.println("bigdata? security!");
	}
}
}
