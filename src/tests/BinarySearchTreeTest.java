package tests;

import dataStructures.BinarySearchTree;
import exceptions.Underflow;
import java.util.Scanner;


public class BinarySearchTreeTest {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        //variables for Test program
        String skip;       // skip end of line after reading an integer
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
            System.out.println("1: isEmpty()");
            System.out.println("2: size()");
            System.out.println("3: size2()");
            System.out.println("4: contains (string)");
            System.out.println("5: remove (string)");
            System.out.println("6: get (string)");
            System.out.println("7: add (string)");
            System.out.println("8: print (traversal order)");
            System.out.println("9: stop Testing \n");
            System.out.print("Enter choice: ");

            if (kb.hasNextInt())
                method4BST = kb.nextInt();

            else {
                System.out.println("Error: you must enter an integer.");
                System.out.println("Terminating test.");
                return;
            }

            skip = kb.nextLine();
            switch (method4BST) {
                case 1:  // isEmpty()
                    System.out.println("isEmpty returns " + tree.isEmpty());
                    break;

                case 2:  // size()
                    System.out.println("size returns " + tree.size());
                    break;

                case 3:  // size2()
                    try {
                        System.out.println("size2 returns " + tree.size2());
                    } catch (Underflow e) {
                        System.out.println("Tree is empty.");
                        e.printStackTrace();
                    }
                    break;

                case 4:  // contains()
                    System.out.print("Enter a string to search for: ");
                    target = kb.nextLine();
                    System.out.println("contains(" + target + ") returns: " + tree.contains(target));
                    break;

                case 5:  // remove()
                    System.out.print("Enter a string to remove: ");
                    target = kb.nextLine();
                    System.out.println("remove(" + target + ") returns " + tree.remove(target));
                    break;

                case 6:  // get()
                    System.out.print("Enter a string to get: ");
                    target = kb.nextLine();
                    System.out.println("get(" + target + ") returns " + tree.get(target));
                    break;

                case 7:  // add()
                    System.out.print("Enter a string to add: ");
                    element = kb.nextLine();
                    tree.add(element);
                    break;

                case 8:  // Order tree and print
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
                    skip = kb.nextLine();

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
                    break;

                case 9:  // stop testing
                    continueTest = false;
                    break;

                default:
                    System.out.println("Error in method selection. Terminating test.");
                    return;
            }
        }
        System.out.println("Binary Search Tree test has completed.");
        kb.close();
    }

}