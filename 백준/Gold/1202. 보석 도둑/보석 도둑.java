import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Jewel {
        int weight, cost;

        Jewel() {
        }

        Jewel(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewel> jewels1 = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            jewels1.add(new Jewel(weight, cost));
        }
        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            int bag = Integer.parseInt(br.readLine());
            bags.add(bag);
        }
        long totalCost = 0;
        PriorityQueue<Jewel> jewels2 = new PriorityQueue<>((o1, o2) -> {
            return o2.cost - o1.cost;
        });
        while (!bags.isEmpty()) {
            int bag = bags.poll();
            while (!jewels1.isEmpty() && jewels1.peek().weight <= bag) {
                jewels2.add(jewels1.poll());
            }
            if (!jewels2.isEmpty()) {
                totalCost += jewels2.poll().cost;
            }
        }
        System.out.println(totalCost);
    }
}
