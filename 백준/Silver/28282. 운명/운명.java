import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int K = sc.nextInt();
        int[] left = new int[K+1];
        for(int i = 0; i<X ;++i){
            int num = sc.nextInt();
            ++left[num];
        }
        int[] right = new int[K+1];
        for(int i = 0; i<X ;++i){
            int num = sc.nextInt();
            ++right[num];
        }
        long ans = 0;
        for(int i = 1; i<=K; ++i){
            ans += left[i]*((long)X-right[i]);
        }
        
        System.out.println(ans);
    }
}