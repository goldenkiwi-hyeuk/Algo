import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max;

    static class Node {

        List<Node> children;
        Node parent;
        int idx, weight, mymaxweight;
        int maxweight = 0;
        int secondmaxweight = 0;
    }

    static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodes = new ArrayList<Node>();
        max = 0;
        for (int i = 0; i <= N; i++) {
            nodes.add(new Node());
        }
        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (nodes.get(start).children != null) {
                nodes.get(start).children.add(nodes.get(end));
                nodes.get(end).parent = nodes.get(start);
                nodes.get(end).idx = end;
                nodes.get(end).weight = weight;
            } else {
                nodes.get(start).idx = start;
                nodes.get(start).children = new ArrayList<>();
                nodes.get(start).children.add(nodes.get(end));
                nodes.get(end).parent = nodes.get(start);
                nodes.get(end).idx = end;
                nodes.get(end).weight = weight;
            }
        }
        checkMaxEdge(1);
        System.out.println(max);
    }

    private static void checkMaxEdge(int i) {
        if (nodes.get(i).children == null) {
            nodes.get(i).mymaxweight = nodes.get(i).weight;
            if (nodes.get(i).mymaxweight > max) {
                max = nodes.get(i).mymaxweight;
            }
        } else {
            for (Node n : nodes.get(i).children) {
                checkMaxEdge(n.idx);
                if (nodes.get(i).maxweight < n.mymaxweight) {
                    nodes.get(i).secondmaxweight = nodes.get(i).maxweight;
                    nodes.get(i).maxweight = n.mymaxweight;
                } else if (nodes.get(i).secondmaxweight < n.mymaxweight) {
                    nodes.get(i).secondmaxweight = n.mymaxweight;
                }
            }
            if (nodes.get(i).maxweight+nodes.get(i).secondmaxweight > max) {
                max = nodes.get(i).maxweight+nodes.get(i).secondmaxweight;
            }
            nodes.get(i).mymaxweight = nodes.get(i).maxweight + nodes.get(i).weight;
        }
    }
}
