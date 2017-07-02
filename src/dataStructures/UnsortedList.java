package dataStructures;

import exceptions.Duplicate;
import exceptions.EmptyList;

/**
 * Created by Matt on 6/18/2017.
 */
public class UnsortedList<data> implements InterfaceList<data> {
    protected final int sizeMax = 100; // default capacity
    protected int originalSize;       // original capacity
    protected data[] list;             // array to hold this list’s elements
    protected int numElements = 0;     // number of elements in this list
    protected int currentPosition;     // current position for iteration

    /**
     * Set by search method
     */
    protected boolean found;  // true if element found, otherwise false
    protected int location;   // indicates location of element if found

    /**
     * Creates default sized list
     */
    public UnsortedList() {
        list = (data[]) new Object[sizeMax];
        originalSize = sizeMax;
    }

    /**
     * Creates list with user defined size
     */
    public UnsortedList(int originalSize) {
        list = (data[]) new Object[originalSize];
        this.originalSize = originalSize;
    }

    /**
     * Local method to increment the capacity of the list by an amount equal to the original capacity
     */
    protected void increaseSize() {
        // Create the larger array.
        data[] larger = (data[]) new Object[list.length + originalSize];

        // Copy the data from the smaller array into the larger array.
        for (int i = 0; i < numElements; i++) {
            larger[i] = list[i];
        }

        // Reassign list reference.
        list = larger;
    }

    /**
     * Local method to search the list for an occurrence of the data element such that
     * data.equals(target). If successful, sets instance variables found to true and location to the array
     * index of data. If not successful, sets found to false.
     */
    protected void search(data target) throws EmptyList {
        location = 0;
        found = false;

        if (location == numElements) {
            throw new EmptyList("List is empty. No elements to search.");
        }

        while (location < numElements) {
            if (list[location].equals(target)) {
                found = true;
                return;
            } else
                location++;
        }
    }

    /**
     * Returns the number of elements on this list.
     */
    public int size() {
        return originalSize;
    }

    /**
     * Adds defined element data to the list and throws Duplicate Exception if element data already exists
     */
    public void add(data element) throws Duplicate {
        if (numElements == list.length)
            increaseSize();
        list[numElements] = element;
        numElements++;
    }

    /**
     * Removes defined element data from the list such that data.equals(element) and returns true, otherwise false
     */
    public boolean remove(data element) {
        try {
            search(element);
        } catch (EmptyList emptyList) {
            System.out.println("List is empty. No elements to search.");
        }
        if (found) {
            list[location] = list[numElements - 1];
            list[numElements - 1] = null;
            numElements--;
        }
        return found;
    }

    /**
     * Returns true if the list contains an element data such that data.equals(element); otherwise, false.
     */
    public boolean contains(data element) {
        try {
            search(element);
        } catch (EmptyList emptyList) {
            System.out.println("List is empty. No elements to search.");
        }
        return found;
    }

    /**
     * Returns an element data from the list such that data.equals(element); if no such element exists, returns null.
     */
    public data get(data element) throws EmptyList {
        search(element);
        if (found)
            return list[location];
        else
            return null;
    }

    /**
     * Initializes current position for an iteration through the list, to the first element on the list.
     */
    public void reset() {
        currentPosition = 0;
    }

    public boolean isEmpty() {
        return (numElements == 0);
    }

    /**
     * Returns the element at the current position on this list.
     * If the current position is the last element, then it advances the value
     * of the current position to the first element; otherwise, it advances
     * the value of the current position to the next element.
     * Assumes the list is not empty, has been reset, and not modified since recent reset
     */
    public data getNext() {
        data next = list[currentPosition];
        if (currentPosition == (numElements - 1))
            currentPosition = 0;
        else
            currentPosition++;
        return next;
    }

    public String toString() {
        String listString = "List:\n";
        for (int i = 0; i < numElements; i++)
            listString = listString + "  " + list[i] + "\n";
        return listString;
    }
}
