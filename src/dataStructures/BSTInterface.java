package dataStructures;

import exceptions.Underflow;

/**
 * Interface for a class that implements a binary search tree (BST).
 * The trees are unbounded and allow duplicate elements, but do not allow null elements. As a general
 * precondition, null elements are not passed as arguments to any of the methods.
 *
 * The tree supports iteration through its elements in INORDER, PREORDER, and POSTORDER.
 */
public interface BSTInterface<data extends Comparable<data>> {
    /**Used to specify traversal order */
    int INORDER = 1;
    int PREORDER = 2;
    int POSTORDER = 3;

    /**Returns true if the BST is empty; otherwise, returns false */
    boolean isEmpty();

    /**Returns the number of elements in the BST */
    int size();

    /**Returns true if the BST contains an element data such that data.compareTo(element) == 0;
     * otherwise, returns false */
    boolean contains(data element);

    /**Removes an element data from the BST such that data.compareTo(element) == 0
     * and returns true; if no such element exists, returns false */
    boolean remove(data element) throws Underflow;

    /**Returns an element data from the BST such that data.compareTo(element) == 0;
     * if no such element exists, returns null.*/
    data get(data element);

    /**Adds element to the BST. The tree retains its BST property. */
    void add(data element);

    /**Initializes current position for an iteration through the BST
     * in orderType order. Returns current number of nodes in the BST*/
    int reset(int orderType);

    /**Returns the element at the current position on the BST for orderType
     * and advances the value of the current position based on the orderType. */
    data getNext(int orderType);
}
