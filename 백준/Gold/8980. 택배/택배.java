import java.io.*;
import java.util.*;

public class Main {
    
    // 기본 아이디어
    // 택배라는 객체 생성이후 거리(택배의 도착점 - 택배의 출발점)계산후 거리가 짧은순으로 정렬 만약 거리가 같다면 출발점이 빠른 순으로 정렬
    // 택배의 출발점부터 도착점-1까지 가지고 갈수 있는 용량을 구함 Math.min활용
    // 결과값을 더하기
    
    private static class TackBae implements Comparable<TackBae>{
        int start, end, amount;
        
        public TackBae(){}
        
        public TackBae(int start, int end, int amount){
            this.start = start;
            this.end = end;
            this.amount = amount;
        }
        
        @Override
        public int compareTo(TackBae o){
            if((this.end-this.start) == (o.end-o.start)){
                return this.start - o.start;    
            }
            return (this.end-this.start) - (o.end-o.start);
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1]; // 계획 상 각 지점에서 가지고 있는 택배량을 계산한 값
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<TackBae> pq = new PriorityQueue<>();
        for(int i = 0; i<M ; ++i){
            str = br.readLine();
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            pq.add(new TackBae(start, end, amount));
        }
        int ans = 0;
        while(!pq.isEmpty()){
            TackBae tackbae = pq.poll();
            int amount = 987654321; // 최소값을 가져갈 예정
            for(int i = tackbae.start; i< tackbae.end; ++i){
                amount = Math.min(Math.min(amount, C-arr[i]),tackbae.amount); // 여태까지 계산된 최소값, 현재 위치에 탑차 가능한 물류량, 택배 자체 물류량 3개중 가장 작은 값 판별
                if(amount == 0){ // 중간에 0이 나온다면 해당 택배는 배송불가
                    break;
                }
            }
            if(amount != 0){
                for(int i = tackbae.start; i< tackbae.end; ++i){ // arr[i] 최신화
                    arr[i] += amount; // 계획 상 각 지점에서 가지고 있는택배량 더하기
                }
                ans += amount; // 가능한 운반 택배 갯수 더해주기
            }
        }
        System.out.println(ans);
    }
}