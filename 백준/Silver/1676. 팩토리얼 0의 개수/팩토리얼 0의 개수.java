import java.math.BigInteger;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	BigInteger bigNumber1 = factorial(N);
	String str = bigNumber1.toString();
	int count = 0;
	for(int i = str.length()-1; i>=0; --i) {
		if(str.charAt(i)!='0') {
			break;
		} else {
			++count;
		}
	}
	System.out.println(count);
}

	public static BigInteger factorial(int num) {
		if(num==0||num==1) {
			return BigInteger.ONE;
		}
		return factorial(num-1).multiply(BigInteger.valueOf(num));
	}
}
