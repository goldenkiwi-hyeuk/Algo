import java.util.*;

class Solution {
    static char[][] map;
    static int R, C;
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        R = m;
        C = n;
        map = new char[R][C];
        for(int i = 0 ; i<R; ++i){
            for(int j = 0; j <C ; ++j){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            // 블록제거
            int deleteBlockCnt = delBlock();
            // 제거되는 블록이 없다면 반복문 종료
            if (deleteBlockCnt == 0){
                break;
            }
            answer += deleteBlockCnt;

            // 블록 내리기
            blockDown();
            
        }
        return answer;
    }
    
    private static int delBlock(){
        Set<Integer> delList = new HashSet<>();
        for(int i = 0 ; i<R; ++i){
            for(int j = 0; j <C ; ++j){
                // 비어있는 상태가 아니라면 제거가능한지 체크해야함
                if(map[i][j]!='.'){
                    if(i<R-1&& j<C-1){
                        if(map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]){
                            delList.add(i*100+j);
                            delList.add(i*100+j+1);
                            delList.add((i+1)*100+j);
                            delList.add((i+1)*100+j+1);
                        }
                    }
                }
            }
        }
        
        // 제거할 후보군 제거하기
        for(int num : delList){
            int r = num/100;
            int c = num%100;
            map[r][c] = '.';
        }
        
        return delList.size();
    }
    
    private static void blockDown(){
        for(int i = 0; i<R; ++i){
            for(int j = 0; j<C; ++j){
                if(map[i][j] == '.'){
                    for(int k = i; k>=1 ; --k){
                        map[k][j] = map[k-1][j];
                    }
                    map[0][j] = '.';
                }
            }
        }
    }
}