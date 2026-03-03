import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            return o2-o1;
        });
        for(int i = 0; i<N ;++i){
            int c = sc.nextInt();
            pq.add(c);
        }
        int total = 0;
        while(!pq.isEmpty()){
            int[] arr = new int[3];
            try{
                for(int i = 0; i<3; ++i){
                    arr[i] = pq.poll();
                }
            } catch(Exception e){
                
            }
            total += (arr[0]+arr[1]);
        }
        System.out.println(total);
    }
}