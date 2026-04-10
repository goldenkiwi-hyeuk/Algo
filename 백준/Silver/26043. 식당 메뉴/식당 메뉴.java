import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Student{
        int num, menu;

        Student(){}

        Student(int num, int menu){
            this.num = num;
            this.menu = menu;
        }
    }
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Student> deq = new ArrayDeque<>();
        List<Integer> eatFavorite = new ArrayList<>();
        List<Integer> eatNonFavorite = new ArrayList<>();
        List<Integer> didNotEat = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command == 1){
                int num = Integer.parseInt(st.nextToken());
                int menu = Integer.parseInt(st.nextToken());
                deq.addLast(new Student(num, menu));
            } else {
                int menu = Integer.parseInt(st.nextToken());
                Student student = deq.pollFirst();
                if (student.menu == menu) {
                    eatFavorite.add(student.num);
                } else {
                    eatNonFavorite.add(student.num);
                }
            }
        }

        while (!deq.isEmpty()) {
            didNotEat.add(deq.pollFirst().num);
        }

        Collections.sort(eatFavorite);
        Collections.sort(eatNonFavorite);
        Collections.sort(didNotEat);

        appendResult(eatFavorite);
        appendResult(eatNonFavorite);
        appendResult(didNotEat);

        System.out.println(sb.toString());
    }

    private static void appendResult(List<Integer> list) {
        if (list.isEmpty()){
            sb.append("None").append("\n");
            return;
        }
        for(int num:list){
            sb.append(num).append(" ");
        }
        sb.append("\n");
        return;
    }
}
