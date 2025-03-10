import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int[] arrk = new int[k+1];
        Arrays.fill(arrk,1);
        Map<Integer, int[]> map;
        int now = k;
        while(now!=n) {
            int[] cnt = new int[k+1];
            for(int cntnum = 1 ; cntnum<=k;++cntnum){
                map = new HashMap<>();
                for(int i = 1; i<=k;++i){
                    if(i == cntnum){
                        map.put(i, new int[arrk[i]+1]);
                    } else {
                        map.put(i, new int[arrk[i]]);    
                    }
                }
                int count[] = new int[k+1];
                for(int[] customer : reqs){
                    int[] kind = map.get(customer[2]);
                    int min = 987654321;
                    int minIdx = -1;
                    for(int i = 0; i<kind.length;++i){
                        if(min > kind[i]){
                            minIdx = i;
                            min = kind[i];
                        }
                    }
                    if( min - customer[0] <= 0 ){
                        kind[minIdx] = customer[0]+customer[1];
                        map.put(customer[2], kind);
                    } else {
                        count[customer[2]] += min - customer[0];
                        kind[minIdx] = min + customer[1];
                        map.put(customer[2], kind);
                    }
                }
                for(int i = 1; i<=k;++i){
                    cnt[cntnum] += count[i];    
                }
            }
            int min = 987654321;
            int minIdx = -1;
            for(int i = 1; i<=k;++i){
                if(min > cnt[i]){
                    min = cnt[i];
                    minIdx = i;
                }
            }

            arrk[minIdx]++;                      
            ++now;
        }
        map = new HashMap<>();
        for(int i = 1; i<=k;++i){
            map.put(i, new int[arrk[i]]);
        }
        int count[] = new int[k+1];
        for(int[] customer : reqs){
            int[] kind = map.get(customer[2]);
            int min = 987654321;
            int minIdx = -1;
            for(int i = 0; i<kind.length;++i){
                if(min > kind[i]){
                    minIdx = i;
                    min = kind[i];
                }
            }
            if( min - customer[0] <= 0 ){
                kind[minIdx] = customer[0]+customer[1];
                map.put(customer[2], kind);
            } else {
                count[customer[2]] += min - customer[0];
                kind[minIdx] = min + customer[1];
                map.put(customer[2], kind);
            }
        }
        int answer = 0;
        for(int i = 1; i<= k;++i){
            answer += count[i];
        }
        return answer;
    }
}