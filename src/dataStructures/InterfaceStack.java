package dataStructures;

import exceptions.Overflow;
import exceptions.Underflow;


/**Stack requires: Push, pop, top, isEmpty, isFull (array), size, toString */

interface InterfaceStack<data> {

    void push(data element) throws Overflow;

    data pop() throws Underflow;

    data top() throws Underflow;

    boolean isEmpty();

    boolean isFull();

    int size();

    String toString();

}
