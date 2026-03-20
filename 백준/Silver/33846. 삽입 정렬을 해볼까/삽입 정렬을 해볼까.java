import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; ++i){
            arr[i] = sc.nextInt();
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<t; ++i){
            pq.add(arr[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append(" ");
        }
        for(int i = t; i<n; ++i){
            sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}