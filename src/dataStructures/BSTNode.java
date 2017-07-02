package dataStructures;


public class BSTNode<data extends Comparable<data>> {
    /**Used to hold references to BST nodes for the linked implementation */
    protected data info;                // The info in a BST node
    protected BSTNode<data> left;       // A link to the left child node
    protected BSTNode<data> right;      // A link to the right child node

    public BSTNode(data info) {
        this.info = info;
        left = null;
        right = null;
    }

    /**Returns info of the BSTNode */
    public data getInfo() {
        return info;
    }

    /**Sets info of the BSTNode */
    public void setInfo(data info) {
        this.info = info;
    }

    /**Returns left link of the BSTNode */
    public BSTNode<data> getLeft() {
        return left;
    }

    /**Sets left link of the BSTNode */
    public void setLeft(BSTNode<data> link) {
        left = link;
    }

    /** Returns right link of the BSTNode */
    public BSTNode<data> getRight() {
        return right;
    }

    /** Sets right link of the BSTNode */
    public void setRight(BSTNode<data> link) {
        right = link;
    }
}
