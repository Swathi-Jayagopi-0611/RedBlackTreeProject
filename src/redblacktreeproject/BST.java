package redblacktreeproject;

public class BST {
    class Node {
        int data;
        Node left, right;

        Node(int d) { data = d; }
    }

    Node root;

    public void insert(int d) {
        root = insertRec(root, d);
    }

    private Node insertRec(Node r, int d) {
        if (r == null) return new Node(d);
        if (d < r.data) r.left = insertRec(r.left, d);
        else r.right = insertRec(r.right, d);
        return r;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node r, int k) {
        if (r == null) return false;
        if (r.data == k) return true;
        return k < r.data ? searchRec(r.left, k) : searchRec(r.right, k);
    }

    public int height(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(height(n.left), height(n.right));
    }
}