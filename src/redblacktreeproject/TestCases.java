package redblacktreeproject;

public class TestCases {

    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();

        // Insert test
        int[] values = {10, 20, 30};

        System.out.print("Inserted elements: ");
        for (int v : values) {
            tree.insert(v);
            System.out.print(v + " ");
        }

        System.out.println("\nElements Inserted Successfully :)");

        // Search test
        System.out.println("Search 20: " + (tree.search(20) != null));

        // Delete test
        tree.delete(20);
        System.out.println("After deletion:");
        tree.visualize();
    }
}