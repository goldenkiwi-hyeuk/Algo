import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1){
            return sticker[0];
        }
        // 첫번째 스티커를 뜯는다는 가정의 dp (마지막 부분은 0을 더한다)
        int[][] dp1 = new int[2][sticker.length];
        dp1[0][0] = sticker[0];
        for(int i = 1; i<sticker.length-1; ++i){
            dp1[0][i] = dp1[1][i-1] + sticker[i]; // 저번을 뜯지 않아야 뜯을수 있음
            dp1[1][i] = Math.max(dp1[0][i-1], dp1[1][i-1]); // 안뜯을거라면 둘중 큰값을 넣으면 된다.
        }
        dp1[0][sticker.length-1] = dp1[1][sticker.length-2] + 0; // 마지막 못뜯으니 0더하기
        dp1[1][sticker.length-1] = Math.max(dp1[0][sticker.length-2], dp1[1][sticker.length-2]);
        // 첫번째 스티커를 안뜯는다는 가정의 dp (처음은 무조건 0 고정)
        int[][] dp2 = new int[2][sticker.length];
        for(int i = 1; i<sticker.length; ++i){
            dp2[0][i] = dp2[1][i-1] + sticker[i]; // 저번을 뜯지 않아야 뜯을수 있음
            dp2[1][i] = Math.max(dp2[0][i-1], dp2[1][i-1]); // 안뜯을거라면 둘중 큰값을 넣으면 된다.
        }
        
        return Math.max(Math.max(dp1[0][sticker.length-1],dp1[1][sticker.length-1]),Math.max(dp2[0][sticker.length-1],dp2[1][sticker.length-1]));
    }
}