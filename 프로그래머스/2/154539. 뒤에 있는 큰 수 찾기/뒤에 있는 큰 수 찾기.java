import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i = numbers.length-1; i>=0; --i){
            // System.out.println("i : "+i+", numbers[i] : "+ numbers[i]);
            // System.out.println(deq.toString());
            // stack이 비어있다면 answer[i] = -1이고 스택에 numbers[i] 추가
            if(deq.isEmpty()){
                answer[i] = -1;
                deq.addFirst(numbers[i]);
                continue;
            } else {
                // stack이 비어있지 않다면 numbers[i]를 stack최상단과 비교하면서 stack을 갱신
                while(!deq.isEmpty()){
                    if(numbers[i]<deq.peekFirst()){
                        answer[i] = deq.peekFirst();
                        deq.addFirst(numbers[i]);
                        break;
                    } else {
                        deq.pollFirst();
                    }
                }
                // 스택이 비어있다면 스택안에 모든값이 현재 numbers[i]보다 작다는 의미  answer[i] = -1이고 스택에 numbers[i] 추가
                if(deq.isEmpty()){
                    answer[i] = -1;
                    deq.addFirst(numbers[i]);
                    continue;
                }
            }
        }
        return answer;
    }
}