package dataStructures;

import exceptions.Duplicate;
import exceptions.ElementNotExist;
import exceptions.EmptyList;
import exceptions.IndexOutOfBounds;

import java.io.Serializable;

/**
 * Indexed List requires: add, set, remove, IndexOf, contains, isEmpty, size, get, toString, reset, getNext
 * Methods: size(), contains(), reset(), getNext(), and isEmpty() are extended from super()
 */

public class IndexedList<data> extends UnsortedList<data> implements InterfaceIndexedList<data>, Serializable {

    /**
     * Creates default sized list from UnsortedList
     */
    public IndexedList() {
        super();
    }

    /**
     * Creates list with user defined size from UnsortedList
     */
    public IndexedList(int originalSize) {
        super(originalSize);
    }

    /**
     * Throws IndexOutOfBounds Exception if passed an index argument
     * such that index < 0 or index > size().
     * Otherwise, adds element to this list at position index; all current
     * elements at that position or higher have 1 added to their index.
     */
    public void add(int index, data element) throws Duplicate, IndexOutOfBounds {
        if ((index < 0) || (index > size()))
            throw new IndexOutOfBoundsException("illegal index of " + index +
                    " passed to ArrayIndexedList add method.\n");

        if (numElements == list.length)
            increaseSize();

        for (int i = numElements; i > index; i--)
            list[i] = list[i - 1];

        list[index] = element;
        numElements++;
    }

    /**
     * Throws IndexOutOfBounds Exception if passed an index argument
     * such that index < 0 or index >= size().
     * Otherwise, replaces element on this list at position index and
     * returns the replaced element.
     */
    public data set(int index, data element) throws IndexOutOfBounds {
        if ((index < 0) || (index >= size()))
            throw new IndexOutOfBounds("Illegal index of " + index +
                    " passed to the List set method.\n");

        data hold = list[index];
        list[index] = element;
        return hold;
    }

    /**
     * Override required in order to declare get(index, element)
     */
    @Override
    public data get(int index) throws IndexOutOfBounds {
        if ((index < 0) || (index >= size()))
            throw new IndexOutOfBounds("Illegal index of " + index +
                    " passed to Indexed List set method.\n");
        else
            return list[index];
    }

    /**
     * Throws IndexOutOfBounds Exception if passed an index argument
     * such that index < 0 or index >= size().
     * Otherwise, returns the element on this list at position index.
     */
    public data get(int index, data element) throws IndexOutOfBounds, EmptyList {
        if ((index < 0) || (index >= size()))
            throw new IndexOutOfBounds("Illegal index of " + index +
                    " passed to Indexed List set method.\n");
        search(element);
        if (!found)
            throw new EmptyList("Element does not exist. List may be empty.");

        return list[index];
    }

    /**
     * If this list contains an element data such that data.equals(element), then returns the index of the first such
     * element. Otherwise, throws Element not exist Exception.
     */
    public int indexOf(data element) throws ElementNotExist {
        try {
            search(element);
        } catch (EmptyList emptyList) {
            System.out.println("List is empty. No elements to search.");
        }
        if (found)
            return location;
        else
            throw new ElementNotExist("Element does not exist.");
    }

    /**
     * Throws IndexOutOfBounds Exception if passed an index argument
     * such that index < 0 or index >= size().
     * Otherwise, removes element on this list at position index and
     * returns the removed element; all current elements at positions
     * higher than that position have 1 subtracted from their index.
     */
    public data remove(int index) {
        if ((index < 0) || (index >= size()))
            try {
                throw new IndexOutOfBounds("Illegal index of " + index +
                        " passed to Indexed List remove method.\n");
            } catch (IndexOutOfBounds indexOutOfBounds) {
                indexOutOfBounds.printStackTrace();
            }

        data hold = list[index];
        for (int i = index; i < numElements; i++)
            list[i] = list[i + 1];

        list[numElements] = null;
        numElements--;
        return hold;
    }

    public String toString() {
        String listString = "List:\n";
        for (int i = 0; i < numElements; i++)
            listString = listString + "[" + i + "] " + list[i] + "\n";
        return listString;
    }
}
