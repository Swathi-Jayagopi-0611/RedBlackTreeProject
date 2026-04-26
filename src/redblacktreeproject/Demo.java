package redblacktreeproject;

public class Demo {

    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();

        int[] values = {10, 20, 30, 15, 25, 5};

        for (int v : values) {
            tree.insert(v);
            System.out.println("\nInserted: " + v);
            tree.visualize();
        }

        System.out.println("\nDeleting 20...");
        tree.delete(20);
        tree.visualize();

        System.out.println("\nInorder:");
        tree.inorder(tree.getRoot());
    }
}