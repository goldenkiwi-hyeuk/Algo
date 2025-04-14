import java.io.*;
import java.util.*;

class Main {
    private static class Date{
        int startM, startD, endM, endD;
        
        Date(){}
        
        Date(int startM, int startD, int endM, int endD){
            this.startM = startM;
            this.startD = startD;
            this.endM = endM;
            this.endD = endD;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Date[] flowers = new Date[N];
        for(int i = 0; i<N;++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());
            flowers[i] = new Date(startM, startD, endM, endD);
        }
        
        Arrays.sort(flowers, (o1,o2)->{
            if(o1.startM == o2.startM){
                if(o1.startD == o2.startD){
                    if(o1.endM == o2.endM){
                        return o2.endD - o1.endD;
                    } else {
                        return o2.endM - o1.endM;
                    }
                } else {
                    return o1.startD-o2.startD;
                }
            } else {
                return o1.startM-o2.startM;
            }
        });
        // for(int i = 0; i<N;++i){
        //     System.out.print(flowers[i].startM);
        //     System.out.print(" ");
        //     System.out.print(flowers[i].startD);
        //     System.out.print(" ");
        //     System.out.print(flowers[i].endM);
        //     System.out.print(" ");
        //     System.out.print(flowers[i].endD);
        //     System.out.println(" ");
        // }
        int cnt = 0;
        int idx = 0;
        int startM = 3;
        int startD = 1;
        while(true){
            // System.out.println("startM : "+startM +", startD : "+startD);
            if(startM>=12){
                break;
            }
            int targetM = -1;
            int targetD = -1;
            for(int i = idx ; i<N ; ++i){
                // System.out.println("flowers[i].startM : "+flowers[i].startM +", flowers[i].startD : "+flowers[i].startD);
                if((flowers[i].startM < startM )|| (flowers[i].startM == startM&&flowers[i].startD <= startD)){
                    ++idx;
                    if(flowers[i].endM>targetM){
                        targetM = flowers[i].endM;
                        targetD = flowers[i].endD;
                    } else if(flowers[i].endM == targetM){
                        if(flowers[i].endD>targetD){
                            targetD = flowers[i].endD;
                        }
                    }
                } else {
                    break;
                }
            }
            
            if(targetM == -1 && targetD == -1){
                cnt = 0;
                break;
            } else {
                ++cnt;
                startM = targetM;
                startD = targetD;
            }
        }
        System.out.println(cnt);
    }
}