import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String T = sc.next();
        int cnt = 0;
        for(int i = 0; i<N/2;++i){
            char a = T.charAt(i);
            char b = T.charAt(N-1-i);
            if(a == '?'&& b=='?'){
                    cnt += 26;
            } else if(a == b){
                continue;
            } else {
                 if(a=='?'|| b=='?'){
                    ++cnt;
                } else {
                    cnt = 0;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}