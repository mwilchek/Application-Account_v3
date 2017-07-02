package dataStructures;

import exceptions.Duplicate;
import exceptions.EmptyList;
import java.io.Serializable;

/**
 * Master interface for any type array list data structure
 */
public interface InterfaceList<data> extends Serializable{
    /**Returns the number of elements in the list */
    int size();

    /**Adds element to this list that is not a duplicate */
    void add(data element) throws Duplicate;

    /**Removes an element data from this list such that data.equals(element)
     * and returns true; if no such element exists, returns false. */
    boolean remove (data element);

    /**Returns true if the list contains an element (data) such that
     * data.equals(element); otherwise, returns false.  */
    boolean contains (data element);

    /**Returns an element (data) from this list such that data.equals(element)
     * if no such element exists, throws EmptyList Exception. */
    data get(data element) throws EmptyList;

    /**Returns a formatted string that represents the list */
    String toString();

    /**Initializes current position for an iteration through the list
     * to the first element on the list. */
    void reset();

    /**Returns the element at the current position on this list.
     * If the current position is the last element, then it advances the value
     * of the current position to the first element; otherwise, it advances
     * the value of the current position to the next element.
     * Assumes the list is not empty, has been reset, and not modified since recent reset*/
    data getNext();
}

