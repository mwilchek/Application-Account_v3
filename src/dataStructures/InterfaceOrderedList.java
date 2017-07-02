package dataStructures;

import exceptions.Duplicate;
import exceptions.IndexOutOfBounds;

import java.io.Serializable;

/**Ordered List requires: add, remove, contains, isEmpty, size, get, toString, reset, getNext */

interface InterfaceOrderedList<data extends Comparable> extends Iterator<data>, Serializable {

    int size();

    void add(data element) throws Duplicate, IndexOutOfBounds;

    data remove(data element) throws IndexOutOfBounds;

    boolean contains(data element) throws IndexOutOfBounds, Duplicate;

    data get(data element) throws  IndexOutOfBounds;

    String toString();

    boolean isEmpty();

}
