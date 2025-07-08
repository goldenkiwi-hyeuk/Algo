import java.util.*;

class Solution {
    
    // 기본아이디어 : 이분탐색
    public int solution(int[] stones, int k) {
        int left = 1;
        int answer = 0;
        int right = 200000000;
        while(left <= right){
            int mid = (left + right)/2;
            if(checkStones(stones, k, mid)){
                answer = mid;
                right = mid -1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    
    // mid명이 돌다리를 건널수 없다면 true를 반환하는 함수
    private boolean checkStones(int[] stones,int k,int mid){
        int cnt = 0;
        for(int stone : stones){
            if(stone <= mid){
                cnt++;
            } else {
                cnt = 0;
            }
            if(cnt >= k){
                return true;
            }
        }
        return false;
    }
}