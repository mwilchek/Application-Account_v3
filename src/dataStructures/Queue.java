package dataStructures;

import exceptions.QueueOverflow;
import exceptions.QueueUnderflow;

public class Queue<data> implements InterfaceQueue<data> {

    protected final int sizeMax = 100; //default capacity
    protected data[] queue; //array that holds queue elements
    protected int numElements = 0; //number of elements in the queue
    protected int front = 0; //index of front of queue
    protected int back; //index of rear of queue

    public Queue() {
        queue = (data[]) new Object[sizeMax];
        back = sizeMax - 1;
    }

    public Queue(int size) {
        queue = (data[]) new Object[size];
        back = size - 1;
    }

    /**
     * Get number of data elements in the queue
     */
    @Override
    public int size() {
        return numElements;
    }

    /**
     * Adds a new data element to the back of the Queue
     */
    @Override
    public void Enqueue(data element) throws QueueOverflow {
        if (!isFull()) {
            back = (back + 1) % queue.length;
            queue[back] = element;
            numElements = numElements + 1;
        } else
            throw new QueueOverflow("Queue is FULL. Cannot add.");
    }

    /**
     * Returns/removes the top element in the queue and adjusts the size
     */
    @Override
    public data Dequeue() throws QueueUnderflow {

        if (!isEmpty()) {
            data firstInQueue = queue[front]; //instantiate data element
            queue[front] = null; //instantiate data element

            front = (front + 1) % queue.length;
            numElements = numElements - 1;
            return firstInQueue;
        } else
            throw new QueueUnderflow("Queue is EMPTY. Cannot dequeue.");
    }

    /**
     * Checks if the queue is empty or not
     */
    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    /**
     * Checks if the queue is full or not
     */
    @Override
    public boolean isFull() {
        return (numElements == queue.length);
    }

    public String toString() {
        String outString = "";
        for (int i = 0; i < this.queue.length; i++) {
            outString = outString + (queue[i] + ", ");
        }
        outString = outString.replaceAll(", null", "");
        outString = outString.replaceAll("null, ", "");
        return outString;
    }

}
