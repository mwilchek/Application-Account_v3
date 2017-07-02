package dataStructures;

import exceptions.Underflow;
import java.util.LinkedList;

/**A Binary Search Tree that requires: Add, Remove, Contains, IsEmpty, Size, toString, Get, Reset, GetNext */

public class BinarySearchTree<data extends Comparable<data>> implements BSTInterface<data> {
    protected BSTNode<data> root;      // reference to the root of the BST for traversals
    protected LinkedList<data> inOrderQueue;    // queue of info
    protected LinkedList<data> preOrderQueue;   // queue of info
    protected LinkedList<data> postOrderQueue;  // queue of info
    boolean found;   // used for remove

    /** Creates an empty BST object */
    public BinarySearchTree() {
        root = null;
    }

    /** Returns true if this BST is empty; otherwise, returns false */
    public boolean isEmpty() {
        return (root == null);
    }

    /** Returns the number of elements in the tree */
    private int recSize(BSTNode<data> tree) {
        if (tree == null)
            return 0;
        else
            return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
    }

    /** Returns the number of elements in this BST */
    public int size() {
        return recSize(root);
    }

    /** Returns the number of elements in this BST */
    public int size2() throws Underflow {
        int count = 0;
        if (root != null) {
            LinkedListStack<BSTNode<data>> hold = new LinkedListStack<BSTNode<data>>();
            BSTNode<data> currNode;
            hold.push(root);
            while (!hold.isEmpty()) {
                currNode = hold.top();
                hold.pop();
                count++;
                if (currNode.getLeft() != null)
                    hold.push(currNode.getLeft());
                if (currNode.getRight() != null)
                    hold.push(currNode.getRight());
            }
        }
        return count;
    }

    /** Returns true if tree contains an element e such that e.compareTo(element) == 0; otherwise, returns false*/
    private boolean recContains(data element, BSTNode<data> tree) {
        if (tree == null)
            return false;       // element is not found
        else if (element.compareTo(tree.getInfo()) < 0)
            return recContains(element, tree.getLeft());   // Search left subtree
        else if (element.compareTo(tree.getInfo()) > 0)
            return recContains(element, tree.getRight());  // Search right subtree
        else
            return true;        // element is found
    }

    /** Returns true if this BST contains an element e such that e.compareTo(element) == 0; otherwise, returns false */
    public boolean contains(data element) {
        return recContains(element, root);
    }

    /** Returns an element e from tree such that e.compareTo(element) == 0 if no such element exists, returns null */
    private data recGet(data element, BSTNode<data> tree) {
        if (tree == null)
            return null;             // element is not found
        else if (element.compareTo(tree.getInfo()) < 0)
            return recGet(element, tree.getLeft());          // get from left subtree
        else if (element.compareTo(tree.getInfo()) > 0)
            return recGet(element, tree.getRight());         // get from right subtree
        else
            return tree.getInfo();  // element is found
    }

    /** Returns an element e from this BST such that e.compareTo(element) == 0;
     * if no such element exists, returns null*/
    public data get(data element) {
        return recGet(element, root);
    }

    /** Adds element to tree; tree retains its BST property */
    private BSTNode<data> recAdd(data element, BSTNode<data> tree) {
        if (tree == null)
            // Addition place found
            tree = new BSTNode<data>(element);
        else if (element.compareTo(tree.getInfo()) <= 0)
            tree.setLeft(recAdd(element, tree.getLeft()));    // Add in left subtree
        else
            tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
        return tree;
    }

    /** Adds element to this BST. The tree retains its BST property */
    public void add(data element) {
        root = recAdd(element, root);
    }

    /**Returns the information held in the rightmost node in tree */
    private data getPredecessor(BSTNode<data> tree) {
        while (tree.getRight() != null)
            tree = tree.getRight();
        return tree.getInfo();
    }

    /** Removes the information at the node referenced by tree. The user's data in the node referenced by tree is no
     * longer in the tree.  If tree is a leaf node or has only a non-null child pointer, the node pointed to by tree
     * is removed; otherwise, the user's data is replaced by its logical predecessor and the predecessor's
     * node is removed */
    private BSTNode<data> removeNode(BSTNode<data> tree) {
        data data;

        if (tree.getLeft() == null)
            return tree.getRight();
        else if (tree.getRight() == null)
            return tree.getLeft();
        else {
            data = getPredecessor(tree.getLeft());
            tree.setInfo(data);
            tree.setLeft(recRemove(data, tree.getLeft()));
            return tree;
        }
    }

    /** Removes an element e from tree such that e.compareTo(element) == 0, and returns true; if no such element
     * exists, returns false*/
    private BSTNode<data> recRemove(data element, BSTNode<data> tree) {
        if (tree == null)
            found = false;
        else if (element.compareTo(tree.getInfo()) < 0)
            tree.setLeft(recRemove(element, tree.getLeft()));
        else if (element.compareTo(tree.getInfo()) > 0)
            tree.setRight(recRemove(element, tree.getRight()));
        else {
            tree = removeNode(tree);
            found = true;
        }
        return tree;
    }

    /** Removes an element e from this BST such that e.compareTo(element) == 0 and returns true; if no such element
     * exists, returns false.*/
    public boolean remove(data element) {
        root = recRemove(element, root);
        return found;
    }

    /** Initializes inOrderQueue with tree elements in inOrder order */
    private void inOrder(BSTNode<data> tree) {
        if (tree != null) {
            inOrder(tree.getLeft());
            inOrderQueue.add(tree.getInfo());
            inOrder(tree.getRight());
        }
    }

    /**Initializes preOrderQueue with tree elements in preOrder order */
    private void preOrder(BSTNode<data> tree) {
        if (tree != null) {
            preOrderQueue.add(tree.getInfo());
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }

    /** Initializes postOrderQueue with tree elements in postOrder order */
    private void postOrder(BSTNode<data> tree) {
        if (tree != null) {
            postOrder(tree.getLeft());
            postOrder(tree.getRight());
            postOrderQueue.add(tree.getInfo());
        }
    }

    /** Initializes current position for an iteration through this BST in orderType order. Returns
     * current number of nodes in the BST */
    public int reset(int orderType) {
        int numNodes = size();

        if (orderType == INORDER) {
            inOrderQueue = new LinkedList<data>();
            inOrder(root);
        } else if (orderType == PREORDER) {
            preOrderQueue = new LinkedList<data>();
            preOrder(root);
        }
        if (orderType == POSTORDER) {
            postOrderQueue = new LinkedList<data>();
            postOrder(root);
        }
        return numNodes;
    }

    /**Returns the element at the current position on the BST for orderType
     * and advances the value of the current position based on the orderType. */
    public data getNext(int orderType) {
        if (orderType == INORDER)
            return inOrderQueue.remove();
        else if (orderType == PREORDER)
            return preOrderQueue.remove();
        else if (orderType == POSTORDER)
            return postOrderQueue.remove();
        else return null;
    }
}
