import java.util.*;
import java.io.*;

class Main {
    static int[] next;
    static int[] group;
    static int cnt;
    static Map<Integer,Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<T; ++tc){
            int N = Integer.parseInt(br.readLine());
            next = new int[N+1];
            group = new int[N+1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i<= N ; ++i){
                int num = Integer.parseInt(st.nextToken());
                next[i] = num;
            }
            for(int i = 1; i<= N ; ++i){
                if(group[i] == 0){
                    map = new HashMap<>();
                    checkGroup(i);
                }
            }
            int solo = 0;
            for(int i = 1; i<= N ; ++i){
                if(group[i] == -1){
                    ++solo;
                }
            }
            sb.append(solo).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    private static void checkGroup(int num){
        boolean isGroup = false;
        // 다음이 이미 그룹져진 상태이거나 그룹이 안되었다고 판단된 상태인경우
        if(group[num] != 0){
            for(int number : map.keySet()){
                group[number] = -1;
            }
            return;
        }
        // 한번 방문한 케이스
        if(map.containsKey(num)){
            // 3번째 방문일 경우 이미 사이클이 확인됨
            if(map.get(num) == 2){
                for(int number : map.keySet()){
                    if(map.get(number) == 2){
                        // 사이클인 케이스는 그룹져주기
                        if(!isGroup){
                            isGroup = true;
                            ++cnt;
                        }
                        group[number] = cnt;
                    } else {
                        // 사이클이 아닌 케이스는 그룹 불가 판정 내리기
                        group[number] = -1;
                    }
                }
            } else {
                // 2번째 방문일경우 사이클 확인해야할 차례
                map.put(num, 2);
                checkGroup(next[num]);
            }
        } else { // 한번도 방문 안한 케이스
            map.put(num, 1);
            checkGroup(next[num]);
        }
    }
}