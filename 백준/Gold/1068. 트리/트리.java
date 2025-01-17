import java.io.*;
import java.util.*;
public class Main {
    static int leafNodeCount = 0;

    static class Node {
        int value;
        Node parent;
        List<Node> children = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void addChild(Node child) {
            this.children.add(child);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Node> tree = new HashMap<>();
        Node root = null;
        for(int index = 0; index < n; index ++) {
            Node node = new Node(index);
            tree.put(index, node);
        }
        
        for(int index = 0; index < n; index ++) {
            int parentIdx = Integer.parseInt(st.nextToken());
            if(parentIdx == -1) {
                root = tree.get(index);
            } else {
                tree.get(parentIdx).addChild(tree.get(index));
            }
            tree.get(index).setParent(tree.get(parentIdx));
        }

        int nodeToRemove = Integer.parseInt(br.readLine());

        if(nodeToRemove == root.value) {
            System.out.println(0);
            return;
        }
        
        Node removedNode = tree.get(nodeToRemove);
        removedNode.parent.children.remove(removedNode);
        tree.remove(nodeToRemove);

        countLeafNode(root);

        System.out.println(leafNodeCount);
    }

    public static void countLeafNode(Node node) {
        if(node.children.isEmpty()) {
            leafNodeCount ++;
            return;
        }
        
        for(Node child : node.children) {
            countLeafNode(child);
        }
    }
}
