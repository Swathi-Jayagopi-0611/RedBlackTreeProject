package redblacktreeproject;

public class Node {
    int data;
    Node left, right, parent;
    boolean color; // true = RED, false = BLACK

    public Node(int data) {
        this.data = data;
        this.color = true;
    }
}