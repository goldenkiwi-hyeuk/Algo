import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int bidx = 0;
        out : for(int i = 0; i< A.length; ++i){
            if(bidx == B.length) break;
            while(A[i]>=B[bidx]){
                ++bidx;
                if(bidx == B.length) break out;
            }
            ++answer;
            ++bidx;
        }
        return answer;
    }
}