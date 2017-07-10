package tests;

import dataStructures.BinarySearchTree;
import exceptions.Underflow;
import java.util.Scanner;


public class BinarySearchTreeTest {
    public static void main(String[] args) throws Underflow {
        Scanner kb = new Scanner(System.in);

        //variables for Test program
        boolean continueTest; // flag for "choose operation" loop
        int method4BST;     // user's choice of BST method to test
        int order4BST;         // user's choice of ordering for BST

        //variables for BST
        String element;
        String target;
        int treeSize;

        System.out.println("This is a Binary Search Tree test.");

        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        // Test cases
        continueTest = true;
        while (continueTest) {
            System.out.println("\nChoose a BST method to test by selecting the corresponding number: ");
            System.out.println("isEmpty() - 1");
            System.out.println("size() - 2");
            System.out.println("contains (string) - 3");
            System.out.println("remove (string) - 4");
            System.out.println("get (string) - 5");
            System.out.println("add (string) - 6");
            System.out.println("print (traversal order) - 7");
            System.out.println("stop Testing - 8 \n");
            System.out.print("Enter choice: ");

            if (kb.hasNextInt())
                method4BST = kb.nextInt();

            else {
                System.out.println("Error: you must enter an integer.");
                System.out.println("Terminating test.");
                return;
            }

            System.out.println("");

            if (method4BST == 1)
                System.out.println("isEmpty returns " + tree.isEmpty());
            if (method4BST == 2) {
                try {
                    System.out.println("size2 returns " + tree.size2());
                } catch (Underflow e) {
                    System.out.println("Tree is empty.");
                    e.printStackTrace();
                }
            }
            if (method4BST == 3) {
                System.out.print("Enter a string to search for: ");
                target = kb.nextLine();
                System.out.println("contains(" + target + ") returns: " + tree.contains(target));
            }

            if (method4BST == 4) {
                System.out.print("Enter a string to remove: ");
                target = kb.nextLine();
                System.out.println("remove(" + target + ") returns " + tree.remove(target));
            }

            if (method4BST == 5) {
                System.out.print("Enter a string to get: ");
                target = kb.nextLine();
                System.out.println("get(" + target + ") returns " + tree.get(target));
            }

            if (method4BST == 6) {
                System.out.print("Enter a string to add: ");
                element = kb.nextLine();
                tree.add(element);
            }

            if (method4BST == 7) {
                System.out.println("Choose a traversal order to test by selecting the corresponding number:");
                System.out.println("1: Pre-order");
                System.out.println("2: In-order");
                System.out.println("3: Post-order");
                if (kb.hasNextInt())
                    order4BST = kb.nextInt();
                else {
                    System.out.println("Error: you must enter an integer.");
                    System.out.println("Exiting test.");
                    return;
                }
                System.out.println("");

                switch (order4BST) {
                    case 1:
                        treeSize = tree.reset(BinarySearchTree.PREORDER);
                        System.out.println("The tree in Pre-order is: ");
                        for (int count = 1; count <= treeSize; count++) {
                            element = tree.getNext(BinarySearchTree.PREORDER);
                            System.out.println(element);
                        }
                        break;

                    case 2:
                        treeSize = tree.reset(BinarySearchTree.INORDER);
                        System.out.println("The tree in In-order is: ");
                        for (int count = 1; count <= treeSize; count++) {
                            element = tree.getNext(BinarySearchTree.INORDER);
                            System.out.println(element);
                        }
                        break;

                    case 3:
                        treeSize = tree.reset(BinarySearchTree.POSTORDER);
                        System.out.println("The tree in Post-order is: ");
                        for (int count = 1; count <= treeSize; count++) {
                            element = tree.getNext(BinarySearchTree.POSTORDER);
                            System.out.println(element);
                        }
                        break;

                    default:
                        System.out.println("Error in order choice. Exiting test.");
                        return;
                }
            }

            if (method4BST == 8) {
                continueTest = false;
            }

            else {
                System.out.println("Error in method selection. Terminating test.");
            }

        }
        System.out.println("Binary Search Tree test has completed.");
        kb.close();
    }

}