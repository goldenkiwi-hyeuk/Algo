import java.util.*;
import java.io.*;

class Main {
    static int N, M, idx;
    static int[][] board;
    static int[][] delta = {{-1,1,0,0},{0,0,-1,1}};
    static Map<Integer,Integer> map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i = 0; i<N ;++i){
            String str = br.readLine();
            for(int j = 0; j<M ; ++j){
                board[i][j] = str.charAt(j)-48;
            }
        }
        idx = 2;
        map = new HashMap<>();
        for(int i = 0; i<N ;++i){
            for(int j = 0; j<M ; ++j){
                if(board[i][j]==0){
                    board[i][j] = idx;
                    map.put(idx, 1);
                    checkBoard(i, j, idx);
                    ++idx;
                }    
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N ;++i){
            for(int j = 0; j<M ; ++j){
                if(board[i][j] == 1){
                    Set<Integer> set = new HashSet<>();
                    for(int dir = 0; dir<4; ++dir){
                        int nr = i + delta[0][dir];
                        int nc = j + delta[1][dir];
                        if(inRange(nr,nc) && board[nr][nc]>1){
                            set.add(board[nr][nc]);
                        }
                    }
                    int total = 1;
                    for(int num : set){
                        total += map.get(num);
                    }
                    sb.append(total%10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    private static void checkBoard(int row, int col, int idx){
        for(int dir = 0; dir<4; ++dir){
            int nr = row + delta[0][dir];
            int nc = col + delta[1][dir];
            if(inRange(nr,nc) && board[nr][nc] == 0){
                board[nr][nc] = idx;
                map.put(idx, map.get(idx)+1);
                checkBoard(nr, nc, idx);
            }
        }
    }
    
    private static boolean inRange(int row, int col){
        if((row >=0)&&(row<N)&&(col>=0)&&(col<M)){
            return true;
        }
        return false;
    }
}