package dataStructures;

import exceptions.Duplicate;
import exceptions.ElementNotExist;
import exceptions.IndexOutOfBounds;

import java.io.Serializable;

/**Indexed List requires: add, set, remove, IndexOf, contains, isEmpty, size, get, toString, reset, getNext
 *Extends methods from InterfaceList */

public interface InterfaceIndexedList<data> extends InterfaceList<data>, Serializable {
    /**Throws IndexOutOfBounds Exception if passed an index argument
     * such that index < 0 or index > size().
     * Otherwise, adds element to this list at position index; all current
     * elements at that position or higher have 1 added to their index.*/
    void add(int index, data element)  throws IndexOutOfBounds, Duplicate;

    /**Throws IndexOutOfBounds Exception if passed an index argument
     * such that index < 0 or index >= size().
     * Otherwise, replaces element on this list at position index and
     * returns the replaced element.*/
    data set(int index, data element) throws IndexOutOfBounds;

    /**Throws IndexOutOfBounds Exception if passed an index argument
     * such that index < 0 or index >= size().
     * Otherwise, returns the element on this list at position index.*/
    data get(int index) throws IndexOutOfBounds;

    /**If this list contains an element (data) such that data.equals(element),
     * then returns the index of the first such element.
     * Otherwise, throws element does not exist Exception.*/
    int indexOf(data element) throws ElementNotExist;

    /**Throws IndexOutOfBounds Exception if passed an index argument
     * such that index < 0 or index >= size().
     * Otherwise, removes element on this list at position index and
     * returns the removed element; all current elements at positions
     * higher than that position have 1 subtracted from their index.*/
    data remove(int index);
}
