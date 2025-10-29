class Solution {
    public int[] solution(long begin, long end) {
        int start = (int) begin;
        int intEnd = (int) end;
        int[] answer = new int[intEnd-start+1];
        for(int i = start; i <= intEnd; i++){ 
            answer[i - start] = 1;
            answer[i - start] = calculated(i);
        }
        if(start == 1) answer[0] = 0;
        return answer;
    }
    
    private static int calculated(int num) {
        int max = 1;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                max = i;
                if(num / i <= 10000000)
                    return num / i;
            }
        }
        return max;
    }
}