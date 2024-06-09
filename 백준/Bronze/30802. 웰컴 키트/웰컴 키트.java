import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	long N = sc.nextLong();
	long S = sc.nextLong();
	long M = sc.nextLong();
	long L = sc.nextLong();
	long XL = sc.nextLong();
	long XXL = sc.nextLong();
	long XXXL = sc.nextLong();
	long[] arr = {S,M,L,XL,XXL,XXXL};
	long T = sc.nextLong();
	long P = sc.nextLong();
	long cntT =0;
	for(int i=0; i<6;++i) {
		 if(arr[i]%T==0) {
			 cntT += (arr[i]/T);
		 } else {
			 cntT += ((arr[i]/T)+1);
		 }
	}
	System.out.println(cntT);
	System.out.println((N/P)+" "+(N%P));
}
}
