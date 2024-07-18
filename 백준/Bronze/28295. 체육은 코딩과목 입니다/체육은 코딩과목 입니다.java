import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		char[] alpa = {'N','E','S','W'};
		Scanner sc = new Scanner(System.in);
		int dir = 0;
		for(int i =0;i<10;++i) {
			int t = sc.nextInt();
			if(t==1) {
				dir = (dir+1)%4;
			} else if(t==2) {
				dir = (dir+2)%4;
			} else if(t==3) {
				dir = (dir+3)%4;
			}
		}
		System.out.println(alpa[dir]);
	}
}
