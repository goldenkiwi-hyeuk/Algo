import java.util.*;
import java.io.*;

class Main {
    // 기본 아이디어 : 정렬
    // 주어진 배열을 오름차순으로 정렬
    // 2중 for문으로 탐색
    // i가 가장 작은값, j가 가장 큰 값
    // 주헌고통지수 = arr[j] - arr[i]
    // Math.pow(2, i와 j사이의 원소 갯수) 만큼 부분집합이 나온다.
    // ans += (arr[j]-arr[i])*((int) Math.pow(2,j-i)/2)
    // 이를 모듈러 연산 처리한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long mod = 1000000007L;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N ;++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long[] pow2 = new long[N];
        pow2[0] = 1;
        for(int i = 1; i<N ; ++i){
            pow2[i] = (pow2[i-1]*2)%mod;
        }
        long ans = 0;
        for(int i = 0; i<N; ++i){
            for(int j = i+1; j<N; ++j){
                ans = ((ans)%mod + ((arr[j]-arr[i])%mod*(pow2[j-i-1])%mod)%mod)%mod;
            }
        }
        System.out.println(ans);
    }
}