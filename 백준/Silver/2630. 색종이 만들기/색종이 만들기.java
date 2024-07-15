import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int r = 0; r<N;++r){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for(int c = 0; c<N;++c){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {0,0,N});
        int[] answer = {0,0};
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int row = arr[0];
            int col = arr[1];
            int level = arr[2];
            int gap = map[row][col];
//            System.out.println("row : "+row+", col : "+col+", level : "+level);
            boolean isOK = true;
            for(int r = row; r<row+level;++r){
                for(int c = col; c<col+level;++c){
                    if(map[r][c]!=gap){
                        isOK = false;
                        break;
                    }
                }
            }

            if(isOK){
                ++answer[gap];
            } else {
                que.add(new int[] {arr[0],arr[1],(level/2)});
                que.add(new int[] {arr[0]+(level/2),arr[1],(level/2)});
                que.add(new int[] {arr[0],arr[1]+(level/2),(level/2)});
                que.add(new int[] {arr[0]+(level/2),arr[1]+(level/2),(level/2)});
            }
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
