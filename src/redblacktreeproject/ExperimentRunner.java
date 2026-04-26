package redblacktreeproject;

import java.util.*;

public class ExperimentRunner {

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000};
        Random rand = new Random();

        for (int size : sizes) {

            int[] data = new int[size];
            for (int i = 0; i < size; i++)
                data[i] = rand.nextInt(100000);

            RedBlackTree rbt = new RedBlackTree();
            BST bst = new BST();

            long start = System.nanoTime();
            for (int x : data) rbt.insert(x);
            long rbtInsert = System.nanoTime() - start;

            start = System.nanoTime();
            for (int x : data) bst.insert(x);
            long bstInsert = System.nanoTime() - start;

            System.out.println("\nSIZE: " + size);
            System.out.println("RBT Height: " + rbt.height(rbt.getRoot()));
            System.out.println("BST Height: " + bst.height(bst.root));
            System.out.println("RBT Insert Time: " + rbtInsert);
            System.out.println("BST Insert Time: " + bstInsert);
        }
    }
}