import java.io.*;


class Main {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int newValue) {
            if (newValue < this.value) {
                if (this.left == null) {
                    this.left = new Node(newValue);
                } else {
                    this.left.insert(newValue);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(newValue);
                } else {
                    this.right.insert(newValue);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Node root = null;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int value = Integer.parseInt(input);
            if (root == null) {
                root = new Node(value);
            } else {
                root.insert(value);
            }
        }
        postOrder(root);
        System.out.println(sb.toString());
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append("\n");

    }

}