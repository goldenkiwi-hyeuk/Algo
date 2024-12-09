import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int mycost, idx;
        List<Node> children;
        List<Integer> cost;
    }

    static boolean[] visited;
    static int max;
    static List<Node> nodeList;
    static List<Map<Integer,Integer>> map = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        nodeList = new ArrayList<Node>();
        visited = new boolean[V + 1];
        for (int v = 0; v <= V; v++) {
            Map<Integer,Integer> edgeMap = new HashMap<Integer,Integer>();
            map.add(edgeMap);
            List<Node> children = new ArrayList<>();
            List<Integer> cost = new ArrayList<>();
            nodeList.add(new Node());
            nodeList.get(v).idx = v;
            nodeList.get(v).children = children;
            nodeList.get(v).cost = cost;
        }
        map.get(1).put(0,0);
        for (int v = 0; v < V; v++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) {
                    break;
                } else {
                    int cost = Integer.parseInt(st.nextToken());
                    nodeList.get(start).children.add(nodeList.get(end));
                    map.get(start).put(end, cost);
                    map.get(end).put(start,cost);
                }
            }
        }
        max = Integer.MIN_VALUE;
        nodeList.get(1).mycost = 0;
        checkcost(1,0);
        System.out.println(max);
    }

    private static int checkcost(int i, int before) {
        if (i == 0 || visited[i]) {
            return 0;
        }
        visited[i] = true;
        Node node = nodeList.get(i);
        if (node.children.size() == 0) {
            return node.mycost;
        } else {
            for (Node child : node.children) {
                if (!visited[child.idx]) {
                    int childCost = checkcost(child.idx, node.idx);
                    if (childCost != 0) node.cost.add(childCost);
                }
            }
            if (node.cost.size() == 0) {
                return map.get(i).get(before);
            } else if (node.cost.size() == 1) {
                if (node.cost.get(0) > max) {
                    max = node.cost.get(0);
                }
                return node.cost.get(0) + map.get(i).get(before);
            } else {
                Collections.sort(node.cost, Collections.reverseOrder());
                if (node.cost.get(0)+node.cost.get(1) > max) {
                    max = node.cost.get(0) + node.cost.get(1);
                }
                return node.cost.get(0) + map.get(i).get(before);
            }
        }
    }
}
