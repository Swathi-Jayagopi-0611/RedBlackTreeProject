package redblacktreeproject;

import java.util.*;

public class TreeVisualizer {

    public static void printTree(Node root) {
        if (root == null) {
            System.out.println("(empty)");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Node n = q.poll();
                if (n == null) {
                    System.out.print("N ");
                    continue;
                }

                System.out.print(n.data + "(" + (n.color ? "R" : "B") + ") ");
                q.add(n.left);
                q.add(n.right);
            }
            System.out.println();
        }
    }
}