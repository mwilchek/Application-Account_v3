package dataStructures;

import exceptions.Underflow;

public class LinkedListStack<data> implements InterfaceLinkedListStack<data> {

    private LinkedListNode<data> top;
    private int numElement=0;

    @Override
    public data top() throws Underflow {
        if(isEmpty()) {
            throw new Underflow("Stack is empty. Cannot top()");
        }
        return top.getElement();
    }

    @Override
    public data pop() throws Underflow {
        if (isEmpty()) {
            throw new Underflow("Stack is empty. Cannot pop()");
        }
        data element = top.getElement();
        top = top.getPointer();
        return element;
    }

    @Override
    public void push(data element) {
        LinkedListNode<data> newNode = new LinkedListNode<data>(element);
        newNode.setPointer(top);
        top = newNode;
        numElement++;
    }

    @Override
    public boolean isEmpty() {
        return (numElement==0);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return numElement;
    }

    public String toString() {
        LinkedListNode<data> current = top;
        String list="";
        while(current!=null) {
            list+= current.getElement() + "\t";
            current = current.getPointer();
        }
        return list;
    }
}
