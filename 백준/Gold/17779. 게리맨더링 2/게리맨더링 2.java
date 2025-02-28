import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= N; x++) { // row
            for (int y = 1; y <= N; y++) { // col
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if(inRange(x,y,d1,d2)){
                            int[][] map2 = new int[N][N];
                            int num1 = 0;
                            int num2 = 0;
                            int num3 = 0;
                            int num4 = 0;
                            int num5 = 0;
                            for (int r = 1; r <= N; r++) {
                                for (int c = 1; c <= N; c++) {
                                    if ((r>=1)&&(r<x+d1)&&(c>=1)&&(c<=y)&&inRange1(x,y,d1,r,c)){
                                        map2[r-1][c-1] = 1;
                                        num1 += map[r-1][c-1];
                                    } else if ((r>=1)&&(r<=x+d2)&&(c>=y)&&(c<=N)&&inRange2(x,y,d2,r,c)){
                                        map2[r-1][c-1] = 2;
                                        num2 += map[r-1][c-1];
                                    } else if ((r>=x+d1)&&(r<=N)&&(c>=1)&&(c<y-d1+d2)&&inRange3(x,y,d1,r,c)){
                                        map2[r-1][c-1] = 3;
                                        num3 += map[r-1][c-1];
                                    } else if ((r>x+d2)&&(r<=N)&&(c>=y-d1+d2)&&(c<=N)&&inRange4(x,y,d2,r,c)){
                                        map2[r-1][c-1] = 4;
                                        num4 += map[r-1][c-1];
                                    } else {
                                        map2[r-1][c-1] = 5;
                                        num5 += map[r-1][c-1];
                                    }
                                }
                            }
                            int maxV = Math.max(num1, Math.max(num2, Math.max(num3, Math.max(num4, num5))));
                            int minV = Math.min(num1, Math.min(num2, Math.min(num3, Math.min(num4, num5))));
                            if (maxV-minV<min){
                                min = maxV-minV;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }

    private static boolean inRange1(int x, int y, int d1, int r, int c) {
        int x1 = y;
        int y1 = N-x+1;
        int r1 = N-r+1;
        if (r1>c-x1+y1){
            return true;
        } else {
            return false;
        }
    }

    private static boolean inRange2(int x, int y, int d1, int r, int c) {
        int x1 = y;
        int y1 = N-x+1;
        int r1 = N-r+1;
        if (r1>x1+y1-c){
            return true;
        } else {
            return false;
        }
    }

    private static boolean inRange3(int x, int y, int d1, int r, int c) {
        int x1 = y-d1;
        int y1 = N-x+1-d1;
        int r1 = N-r+1;
        if (r1<x1+y1-c){
            return true;
        } else {
            return false;
        }
    }

    private static boolean inRange4(int x, int y, int d2, int r, int c) {
        int x1 = y+d2;
        int y1 = N-x+1-d2;
        int r1 = N-r+1;
        if (r1<c+y1-x1){
            return true;
        } else {
            return false;
        }
    }

    private static boolean inRange(int x, int y, int d1, int d2) {
        if (x+d1+d2>N){
            return false;
        }
        if (y-d1<1){
            return false;
        }
        if (y+d2>N){
            return false;
        }
        return true;
    }
}
