import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0L;
        long sum2 = 0L;
        Deque<Integer> deq1 = new ArrayDeque<>();
        Deque<Integer> deq2 = new ArrayDeque<>();
        for(int i = 0; i<queue1.length; ++i){
            deq1.addLast(queue1[i]);
            sum1 += queue1[i];
        }
        for(int i = 0; i<queue2.length; ++i){
            deq2.addLast(queue2[i]);
            sum2 += queue2[i];
        }
        if ((sum1+sum2)%2 != 0){
            return -1;
        }
        long target = (sum1+sum2)/2;
        int maxSize = (deq1.size()+deq2.size())*2;
        int cnt = 0;
        while(sum1!=target){
            ++cnt;
            if(cnt>= maxSize){
                return -1;
            }
            if(sum1 > target){
                int num = deq1.pollFirst();
                sum1 -= num;
                sum2 += num;
                deq2.addLast(num);
            } else {
                int num = deq2.pollFirst();
                sum2 -= num;
                sum1 += num;
                deq1.addLast(num);
            }
        }
        
        if(sum1 != sum2){
            return -1;
        } else {
            return cnt;
        }
    }
}