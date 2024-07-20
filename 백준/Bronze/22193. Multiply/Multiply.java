import java.math.BigInteger;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int M = sc.nextInt();
	String str = sc.next();
	BigInteger A = new BigInteger(str);
	String str2 = sc.next();
	BigInteger B = new BigInteger(str2);
	System.out.println(A.multiply(B));
}
}
