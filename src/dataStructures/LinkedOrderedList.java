package dataStructures;

import exceptions.Duplicate;
import exceptions.IndexOutOfBounds;

import java.io.Serializable;

/**
 * Ordered List requires: add, remove, contains, isEmpty, size, get, toString, reset, getNext
 */

public class LinkedOrderedList<data extends Comparable> implements InterfaceOrderedList<data>, Serializable {

    private boolean found;
    private int numElements;

    private LinkedListNode<data> position;
    private LinkedListNode<data> location;
    private LinkedListNode<data> previous;
    private LinkedListNode<data> LLOrderedList;

    /**
     * Default unbound OrderedList with no elements
     */
    public LinkedOrderedList() {
        numElements = 0;
        LLOrderedList = null;
        position = null;
    }

    /**
     * Local method to query if data element exists
     */
    protected void find(data target) {
        location = LLOrderedList;
        found = false;

        while (location != null) {
            if (location.getElement().compareTo(target) == 0) {
                found = true;
                return;
            }
            if (location.getElement().compareTo(target) > 0) {
                previous = location;
                location = location.getPointer();
                return;
            } else {
                previous = location;
                location = location.getPointer();
            }
        }
    }

    /**
     * Returns the number of elements in the list
     */
    @Override
    public int size() {
        return numElements;
    }

    /**
     * Adds a specific data element and adjusts the Ordered List.
     * Implements compareTo to adjust order location.
     */
    @Override
    public void add(data element) throws Duplicate {
        find(element);
        if (found) {
            throw new Duplicate("Error element exists. Cannot add.");
        } else {
            LinkedListNode<data> previousLocation;
            LinkedListNode<data> location;
            data listElement;

            location = LLOrderedList;
            previousLocation = null;

            while (location != null) {
                listElement = location.getElement();
                if (((Comparable) listElement).compareTo(element) < 0) {
                    previousLocation = location;
                    location = location.getPointer();
                } else
                    break;
            }
            LinkedListNode<data> newNode = new LinkedListNode<data>(element);

            /**Check if this is the first node of the list or an additional one */
            if (previousLocation == null) {
                newNode.setPointer(LLOrderedList);
                LLOrderedList = newNode;
            } else {
                newNode.setPointer(location);
                previousLocation.setPointer(newNode);

            }
            numElements++; /**Adds to total number of data elements in List */

        }
    }

    /**
     * Removes and returns an existing element on the list if it is identical to the element passed into the method
     */
    @Override
    public data remove(data element) throws IndexOutOfBounds {
        find(element);
        if (found) {
            if (LLOrderedList == location)
                LLOrderedList = LLOrderedList.getPointer();
            else
                previous.setPointer(location.getPointer());
            numElements--;
        } else {
            throw new IndexOutOfBounds("Cannot remove " + element + ". Does not exist.");
        }
        return element;
    }

    /**
     * Returns true if an identical element already exists in the list, otherwise returns false
     */
    @Override
    public boolean contains(data element) throws Duplicate {
        find(element);
        if (found)
            return found;
        else
            throw new Duplicate(element + " does not exist.");
    }

    /**
     * Returns true if this list is empty, otherwise returns false
     */
    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    /**
     * Returns an equivalent data element on the list, if it exists
     */
    @Override
    public data get(data element) throws IndexOutOfBounds {
        find(element);
        if (found)
            return location.getElement();
        else
            throw new IndexOutOfBounds("Cannot get. " + element + " does not exist.");
    }

    /**
     * Sets the current position to the first element of the list
     */
    @Override
    public void reset() {
        position = LLOrderedList;
    }

    /**
     * Returns the next element through iteration, and updates the current position
     */
    @Override
    public data getNext(data element) {
        data next = (data) previous.getPointer().getElement();
        previous = previous.getPointer();

        return next;
    }

    /**
     * Returns a formatted string of the elements in this list
     */
    public String toString() {
        LinkedListNode<data> currNode = LLOrderedList;
        String LLOrderedListString = "List:\n";
        while (currNode != null) {
            LLOrderedListString = LLOrderedListString + " " + currNode.getElement() + "\n";
            currNode = currNode.getPointer();
        }
        return LLOrderedListString;
    }

}

