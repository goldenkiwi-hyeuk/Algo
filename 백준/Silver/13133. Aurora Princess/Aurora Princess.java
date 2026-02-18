import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] mothers = new int[N+1]; 
        int[] fathers = new int[N+1]; 
        for(int i = 1; i<=N; ++i){
            int mother = sc.nextInt();
            int father = sc.nextInt();
            mothers[i] = mother;
            fathers[i] = father;
        }
        int M = sc.nextInt();
        boolean[] alive = new boolean[N+1];
        alive[0] = true;
        for(int i = 0; i<M;++i){
            int person = sc.nextInt();
            alive[person] = true;
        }
        
        int cnt = 0;
        for(int i = 1; i<=N;++i){
            if(!alive[i]){
                if(!alive[mothers[i]]&&!alive[fathers[i]]){
                    ++cnt;
                }
            }
        }
        
        System.out.println(cnt);
    }
}