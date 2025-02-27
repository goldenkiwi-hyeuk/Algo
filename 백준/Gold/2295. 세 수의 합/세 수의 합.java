import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    for(int i = 0; i<N;++i){
        arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    out : for(int i = N-1; i>=1;--i){
        for(int j = i-1; j>=0;--j){
            for(int k = j; k>=0;--k){
                int target = arr[i] - arr[j] - arr[k];
                if(target<0){
                    continue;
                } else {
                    int left = 0;
                    int right = k;
                    while(left<= right){
                        int mid = (left+right)/2;
                        if(target == arr[mid]){
                            System.out.println(arr[i]);
                            break out;
                        } else if(target<arr[mid]) {
                            right = mid-1;
                        } else {
                            left = mid+1;
                        }
                    }
                }
            }    
        }
    }

  }
}