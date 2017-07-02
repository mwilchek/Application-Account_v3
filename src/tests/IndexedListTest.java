package tests;

import Core.AccountIndexedList;
import Core.User;
import dataStructures.IndexedList;
import exceptions.Duplicate;
import exceptions.IndexOutOfBounds;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static Core.AcctDataTracker.readIndexedAccounts;

/**
 * Created by Matt on 6/12/2017.
 */
public class IndexedListTest {
    @Test
    public void size() {
        IndexedList a = new IndexedList();
        System.out.println();
        System.out.println("Testing size()...");
        System.out.println("New Index List created with default size of: " + a.size());

        IndexedList b = new IndexedList(200);
        System.out.println("New Index List created with custom size of: " + b.size());

        System.out.println("Comparison of sizes (0 is both equal, " +
                "1 is default stack less than custom, " +
                "-1 is custom is less than default): " + Integer.compare(a.size(), b.size()));
    }

    /**
     * Tests adding element to list with index and element
     */
    @Test
    public void loadUser() throws Exception {

        /**Assumption: A username was created with mwilchek already in the IndexedList .dat file */
        //User user = new User("mwilchek", "Password#1");
        //AcctDataTracker.outputIndexedAccounts(user);

        IndexedList<User> list = readIndexedAccounts(); //new Read in

        System.out.println("Current Indexed .dat " + list.toString());
        AccountIndexedList.setUsers(list);

        User user = (User) AccountIndexedList.getUsers().get(0);
        System.out.println("Username: " + user.getUserName());
        System.out.println("Password: " + user.getPassword());

    }

    @Test
    public void add() {
        IndexedList a = new IndexedList(15);
        Random rand = new Random();
        for (int i = 0; i <= a.size(); i++) {
            int n = rand.nextInt(200) + 1;
            try {
                a.add(i, n);
            } catch (IndexOutOfBounds index) {
                System.out.println("Warning: Loop attemtped to add an element with index out of bounds.");
            } catch (Duplicate duplicate) {
                System.out.println("Warning: Loop attemtped to add duplicate.");
            }

        }
        System.out.println();
        System.out.println("Testing add()...");
        System.out.println("Current Indexed " + a.toString());
    }

    @Test
    public void set() throws Exception {
        IndexedList a = new IndexedList(5);
        Random rand = new Random();
        for (int i = 0; i <= a.size(); i++) {
            int n = rand.nextInt(50) + 1;
            try {
                a.add(i, n);
            } catch (IndexOutOfBounds index) {
                System.out.println("Warning: Loop attemtped to add an element with index out of bounds.");
            } catch (Duplicate duplicate) {
                System.out.println("Warning: Loop attemtped to add duplicate.");
            }

        }
        System.out.println();
        System.out.println("Testing set()...");
        System.out.println("Current Indexed " + a.toString());
        a.set(2, 99);
        System.out.println("Setting Indexed [2]. Updated " + a.toString());

    }

    @Test
    public void remove() throws Exception {
        IndexedList a = new IndexedList(4);
        Random rand = new Random();
        for (int i = 0; i <= a.size(); i++) {
            int n = rand.nextInt(30) + 1;
            try {
                a.add(i, n);
            } catch (IndexOutOfBounds index) {
                System.out.println("Warning: Loop attemtped to add an element with index out of bounds.");
            } catch (Duplicate duplicate) {
                System.out.println("Warning: Loop attemtped to add duplicate.");
            }

        }
        System.out.println();
        System.out.println("Testing remove()...");
        System.out.println("Current Indexed " + a.toString());
        a.remove(1);
        System.out.println("Removing data element at index [1]. Updated " + a.toString());
    }

    @Test
    public void indexOf() throws Exception {
        IndexedList a = new IndexedList(4);
        /**And also testing add data element with no specified index */
        try {
            a.add(10);
            a.add(20);
            a.add(30);
            a.add(40);
        } catch (Duplicate duplicate) {
            System.out.println("Warning: Loop attemtped to add duplicate.");
        }
        System.out.println();
        System.out.println("Testing indexOf()...");
        System.out.println("Current Indexed " + a.toString());
        System.out.println("The index of the data element 30 is: [" + a.indexOf(30) + "]");
    }

    @Test
    public void contains() throws Exception {
        IndexedList a = new IndexedList(5);
        /**And also testing add data element with no specified index */
        try {
            a.add(11);
            a.add(22);
            a.add(33);
            a.add(44);
        } catch (Duplicate duplicate) {
            System.out.println("Warning: Loop attemtped to add duplicate.");
        }
        System.out.println();
        System.out.println("Testing contains()...");
        System.out.println("Current Indexed " + a.toString());
        System.out.println("Does the element 11 exist? " + a.contains(11));
        System.out.println("Does the element 55 exist? " + a.contains(55));
    }

    @Test
    public void isEmpty() throws Exception {
        IndexedList a = new IndexedList();
        System.out.println();
        System.out.println("Testing isEmpty()...");
        System.out.println("The Ordered List is empty: " + a.isEmpty());
    }

    @Test
    public void get() throws Exception {
        IndexedList a = new IndexedList(5);
        /**And also testing add data element with no specified index */
        try {
            a.add(6);
            a.add(44);
            a.add(7);
            a.add(14);
        } catch (Duplicate duplicate) {
            System.out.println("Warning: Loop attemtped to add duplicate.");
        }
        System.out.println();
        System.out.println("Testing get()...");
        System.out.println("Current Indexed " + a.toString());
        int zero = (int) a.get(0);
        int one = (int) a.get(1);
        System.out.println("Element [0] is: " + zero);
        System.out.println("Element [1] is: " + one);
    }

    @Test
    public void reset() throws Exception {
        IndexedList a = new IndexedList(5);
        try {
            a.add(2);
            a.add(44);
        } catch (Duplicate duplicate) {
            duplicate.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing reset()...");
        a.reset();
        System.out.print("The position for lookup has been reset.");
        System.out.println();
    }

    /**
     * The test of getNext() also tests add(element) and reset()
     */
    @Test
    public void getNext() throws Exception {
        IndexedList a = new IndexedList(4);
        /**And also testing add data element with no specified index */
        try {
            a.add(1);
            a.add(2);
            a.add(3);
            a.add(4);
        } catch (Duplicate duplicate) {
            System.out.println("Warning: Loop attemtped to add duplicate.");
        }
        System.out.println();
        System.out.println("Testing getNext()...");
        System.out.println("Current Indexed " + a.toString());
        int first = (int) a.getNext();
        int after = (int) a.getNext();
        int then = (int) a.getNext();
        System.out.println("The first element is: " + first);
        System.out.println("After is: " + after);
        System.out.println("Then is: " + then);
        a.reset();
        System.out.println("The reset is now: " + (int) a.getNext());
    }

}