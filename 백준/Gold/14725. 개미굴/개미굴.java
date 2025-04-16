import java.io.*;
import java.util.*;

class Main {

    static class Node {
        TreeMap<String, Node> children = new TreeMap<>();
    }

    static void insert(Node root, String[] path) {
        Node current = root;
        for (String food : path) {
            current.children.putIfAbsent(food, new Node());
            current = current.children.get(food);
        }
    }

    static void print(Node node, int depth) {
        for (String key : node.children.keySet()) {
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key);
            print(node.children.get(key), depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] path = new String[k];
            for (int j = 0; j < k; j++) {
                path[j] = st.nextToken();
            }
            insert(root, path);
        }

        print(root, 0);
    }
}