import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Product implements Comparable<Product> {

        int weight, price;

        Product() {
        }

        Product(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Product o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Product> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            pq.add(new Product(weight, price));
        }
        int[][]dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            Product product = pq.poll();
            for (int j = 1; j <= K; j++) {
                if (product.weight > j ) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-product.weight]+product.price);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
