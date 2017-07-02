package tests;


import dataStructures.Queue;
import org.junit.jupiter.api.Test;

/**
 * Created by seeme on 6/12/2017.
 */
public class QueueTest {
    @Test
    public void size() {
        Queue a = new Queue();
        System.out.println();
        System.out.println("Testing size()...");
        System.out.println("New stack created with default size of: " + a.size());

        Queue b = new Queue(200);
        System.out.println("New stack created with custom size of: " + b.size());

        System.out.println("Comparison of sizes (0 is both equal, " +
                "1 is default stack less than custom, " +
                "-1 is custom is less than default): " + Integer.compare(a.size(), b.size()));
    }

    @Test
    public void enqueue() throws Exception {
        Queue a = new Queue();
        a.Enqueue("Tanes");
        a.Enqueue("Matt");
        a.Enqueue("Snoopy");
        System.out.println();
        System.out.println("Testing enqueue()...");
        System.out.println("The current line consists of: " + a.toString());
    }

    @Test
    public void dequeue() throws Exception {
        Queue a = new Queue(4);

        a.Enqueue("Tanes");
        a.Enqueue("Matt");
        a.Enqueue("Snoopy");
        a.Enqueue("Darth Vader");
        System.out.println();
        System.out.println("Testing dequeue()...");
        System.out.println("The current line consists of: " + a.toString());
        a.Dequeue();
        a.Dequeue();
        System.out.println("Dequeued positions 1 and 2. Queue is now: " + a.toString());
    }

    @Test
    public void isEmpty() {
        Queue a = new Queue(4);
        System.out.println();
        System.out.println("Testing isEmpty()...");
        System.out.println("The queue is empty: " + a.isEmpty());
    }

    @Test
    public void isFull() {
        Queue a = new Queue(4);
        a.Enqueue("Tanes");
        a.Enqueue("Matt");
        a.Enqueue("Snoopy");
        a.Enqueue("Darth Vader");
        System.out.println();
        System.out.println("Testing isFull()...");
        System.out.println("The stack is full: " + a.isFull());
    }


}