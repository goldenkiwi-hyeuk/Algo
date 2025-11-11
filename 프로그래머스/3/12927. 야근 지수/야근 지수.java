import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int left = 0;
        int right = 50000;
        while(left<=right){
            int mid = (left+right)/2;
            long need = 0;
            
            for(int work : works){
                if(work > mid){
                    need += (work - mid);
                }
            }
            
            if(need > n){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        int limit = left;

        // 실제로 work를 limit 이하로 줄이면서 남은 n만큼 분배
        Arrays.sort(works);
        long remain = n;
        for (int i = works.length-1; i >= 0 ; i--) {
            if (works[i] > limit) {
                if(remain > works[i] - limit){
                    remain -= (works[i] - limit);
                    works[i] = limit;    
                } else {
                    works[i] -= remain;
                    remain = 0;
                    break;
                }
            }
        }
        
        while (remain > 0) {
            Arrays.sort(works);
            if (works[works.length - 1] == 0) {
                break;    
            }
            works[works.length - 1]--;
            remain--;
        }
        
        for (int work : works){
            answer += (long) work * work;  
        } 
        
        return answer;
    }
}