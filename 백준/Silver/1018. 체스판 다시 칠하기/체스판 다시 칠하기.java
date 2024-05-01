import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] board = new char[N][M];
		for(int r = 0; r<N;++r) {
			String str = sc.next();
			for(int c = 0; c<M;++c) {
				board[r][c]= str.charAt(c);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<N-7;++i) {
			for(int j = 0; j<M-7;++j) {
				int num1 = 0;
				int num2 = 0;
				for(int r = i; r<i+8;++r) {
					for(int c = j; c<j+8;++c) {
						if((r%2==0)&&(c%2==0)&&(board[r][c]!='B')) {
							++num1;
						} else if((r%2==0)&&(c%2==1)&&(board[r][c]!='W')) {
							++num1;
						} else if((r%2==1)&&(c%2==0)&&(board[r][c]!='W')) {
							++num1;
						} else if((r%2==1)&&(c%2==1)&&(board[r][c]!='B')) {
							++num1;
						}
						
						if((r%2==0)&&(c%2==0)&&(board[r][c]!='W')) {
							++num2;
						} else if((r%2==0)&&(c%2==1)&&(board[r][c]!='B')) {
							++num2;
						} else if((r%2==1)&&(c%2==0)&&(board[r][c]!='B')) {
							++num2;
						} else if((r%2==1)&&(c%2==1)&&(board[r][c]!='W')) {
							++num2;
						}
						
					}
				}
				if(min>Math.min(num1, num2)) {
					min = Math.min(num1, num2);
				}
			}
		}
		System.out.println(min);
	}
}
