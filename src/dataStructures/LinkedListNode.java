package dataStructures;

import java.io.Serializable;

/**
 * Created by Matt on 6/14/2017.
 */
public class LinkedListNode<data> implements Serializable {

    LinkedListNode pointer;
    private data element;

    public LinkedListNode(data element) {
        this.element = element;
        this.pointer = null;
    }

    public LinkedListNode(data element, LinkedListNode pointer) {
        this.element = element;
        this.pointer = pointer;
    }

    public data getElement() {
        return element;
    }

    public void setElement(data element) {
        this.element = element;
    }

    public LinkedListNode getPointer() {
        return pointer;
    }

    public void setPointer(LinkedListNode pointer) {
        this.pointer = pointer;
    }
}
