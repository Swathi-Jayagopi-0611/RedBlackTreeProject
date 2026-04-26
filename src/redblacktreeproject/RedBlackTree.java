package redblacktreeproject;

public class RedBlackTree {

    private Node root;
    private final boolean RED = true;
    private final boolean BLACK = false;

    public Node getRoot() {
        return root;
    }

    // LEFT ROTATE
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    // RIGHT ROTATE
    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != null)
            x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    // INSERT
    public void insert(int data) {
        Node node = new Node(data);
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            if (node.data < x.data)
                x = x.left;
            else
                x = x.right;
        }

        node.parent = y;

        if (y == null)
            root = node;
        else if (node.data < y.data)
            y.left = node;
        else
            y.right = node;

        fixInsert(node);
    }

    private void fixInsert(Node k) {
        while (k.parent != null && k.parent.color == RED) {
            if (k.parent == k.parent.parent.left) {
                Node u = k.parent.parent.right;

                if (u != null && u.color == RED) {
                    k.parent.color = BLACK;
                    u.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        rotateLeft(k);
                    }
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    rotateRight(k.parent.parent);
                }
            } else {
                Node u = k.parent.parent.left;

                if (u != null && u.color == RED) {
                    k.parent.color = BLACK;
                    u.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rotateRight(k);
                    }
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    rotateLeft(k.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    // SEARCH
    public Node search(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.data)
                return current;
            current = key < current.data ? current.left : current.right;
        }
        return null;
    }

    // DELETE
    public void delete(int key) {
        Node z = search(key);
        if (z == null) return;

        Node y = z;
        Node x;
        boolean yOriginalColor = y.color;

        if (z.left == null) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == null) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;

            if (y.parent == z) {
                if (x != null) x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (yOriginalColor == BLACK && x != null) {
            fixDelete(x);
        }
    }

    private void fixDelete(Node x) {
        while (x != root && x.color == BLACK) {
            if (x == x.parent.left) {
                Node w = x.parent.right;

                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }

                if ((w.left == null || w.left.color == BLACK) &&
                    (w.right == null || w.right.color == BLACK)) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (w.right == null || w.right.color == BLACK) {
                        if (w.left != null)
                            w.left.color = BLACK;
                        w.color = RED;
                        rotateRight(w);
                        w = x.parent.right;
                    }

                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    if (w.right != null)
                        w.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                Node w = x.parent.left;

                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }

                if ((w.left == null || w.left.color == BLACK) &&
                    (w.right == null || w.right.color == BLACK)) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (w.left == null || w.left.color == BLACK) {
                        if (w.right != null)
                            w.right.color = BLACK;
                        w.color = RED;
                        rotateLeft(w);
                        w = x.parent.left;
                    }

                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    if (w.left != null)
                        w.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        if (x != null)
            x.color = BLACK;
    }

    private void transplant(Node u, Node v) {
        if (u.parent == null)
            root = v;
        else if (u == u.parent.left)
            u.parent.left = v;
        else
            u.parent.right = v;

        if (v != null)
            v.parent = u.parent;
    }

    private Node minimum(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // TRAVERSAL
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + "(" + (node.color ? "R" : "B") + ") ");
            inorder(node.right);
        }
    }

    public int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void visualize() {
        TreeVisualizer.printTree(root);
    }
}