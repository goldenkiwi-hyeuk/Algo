import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        int firstElement = 0;
        int secondElement = 0;
        int max = 0;
        int point = 0;
        boolean lastislast = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for (int i = 0 ; i<N;++i) {
            int fruit = Integer.parseInt(st.nextToken());
            if(deque.isEmpty()){
                deque.add(fruit);
                ++firstElement;
            } else if( deque.size()==1){
                if(fruit == deque.peekFirst()){
                    ++firstElement;
                } else{
                    deque.add(fruit);
                    point = i;
                    ++secondElement;
                }
            } else {
                if(fruit == deque.peekFirst()){
                  if(lastislast){
                      lastislast= false;
                      point = i;
                  }
                  ++firstElement;
                } else if (fruit == deque.peekLast()){
                    if(!lastislast){
                        lastislast= true;
                        point = i;
                    }
                    ++secondElement;
                } else {
                    if(lastislast){
                        deque.pollFirst();
                        firstElement = (i-point);
                        point = i;
                        deque.add(fruit);
                        secondElement = 1;
                    } else {
                        lastislast = true;
                        deque.pollLast();
                        firstElement = (i-point);
                        point = i;
                        deque.add(fruit);
                        secondElement = 1;
                    }
                }
            }
//            System.out.println(deque.toString());
//            System.out.println("firstElement : " + firstElement + ", secondElement : " + secondElement);
//            System.out.println("i : "+i +", point : "+point);
            if(max < firstElement+secondElement){
                max = firstElement+secondElement;
            }
        }
        System.out.println(max);
    }
}
