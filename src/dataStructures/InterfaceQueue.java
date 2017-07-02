package dataStructures;

import exceptions.QueueOverflow;
import exceptions.QueueUnderflow;

/**Queue requires: Enqueue, Dequeue, isEmpty, isFull(array), size, toString */
interface InterfaceQueue<data> {

    void Enqueue(data element) throws QueueOverflow;

    data Dequeue() throws QueueUnderflow;

    boolean isEmpty();

    boolean isFull();

    int size();

    String toString();

}
