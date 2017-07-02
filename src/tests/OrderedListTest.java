package tests;

import Core.User;
import dataStructures.LinkedOrderedList;
import exceptions.Duplicate;
import exceptions.IndexOutOfBounds;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class OrderedListTest {
    @Test
    public void size() {
        LinkedOrderedList a = new LinkedOrderedList();
        System.out.println();
        System.out.println("Testing size()...");
        System.out.println("New Linked Order List created with default size of: " + a.size());
    }

    @Test
    public void user() {

        LinkedOrderedList a = new LinkedOrderedList();

        User user1 = new User( "Matt", "Wilchek", "01/01/2000", "Male",
            "mwilchek", "mwilchek@aol.com", "555-555-5555",
            "Password#1", "C:\\users\\pic" );

        try {
            a.add(user1);
        } catch (Duplicate duplicate) {
            duplicate.printStackTrace();
        }

        System.out.println();
        System.out.println(a.toString());
    }

    @Test
    public void add() {
        LinkedOrderedList a = new LinkedOrderedList();
        Random rand = new Random();
        for (int i = 0; a.size() <= 15; i++) {
            int n = rand.nextInt(50) + 1;
                try {
                    a.add(n);
                } catch (Duplicate duplicate) {
                    System.out.println("Warning: Loop tried adding a duplicate.");
                }
                continue;

        }
        System.out.println();
        System.out.println("Testing add()...");
        System.out.println("Filled Ordered List with random values from 1-50 with 0 duplicates");
        System.out.println(a.toString());
    }

    @Test
    public void remove() {
        LinkedOrderedList a = new LinkedOrderedList();
        try{
            a.add(2);
            a.add(44);
            a.add(7);
            a.add(14);
        } catch (Duplicate duplicate) {
            duplicate.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing remove()...");
        System.out.println("Filled Ordered List, of size 4, with values: ");
        System.out.println(a.toString());
        try{
            a.remove(14);
        } catch (IndexOutOfBounds indexOutOfBounds) {
            indexOutOfBounds.printStackTrace();
        }
        System.out.println("Testing removal of '14': ");
        System.out.println("Updated " + a.toString());
    }

    @Test
    public void contains() {
        LinkedOrderedList a = new LinkedOrderedList();
        Random rand = new Random();
        for (int i = 0; a.size() < 7; i++) {
                int n = rand.nextInt(10) + 1;
                try {
                    a.add(n);
                } catch (Duplicate duplicate) {
                    System.out.println("Warning: Loop tried adding a duplicate.");
                }
            }
        System.out.println();
        System.out.println("Testing contains()...");
        System.out.println("Filled Ordered List, with random values from 1-10.");
        try {
            System.out.println("Does element '5' exist?: " + a.contains(5));
        } catch (Duplicate duplicate) {
            System.out.println("Does element '5' exist?: False");
        }
        System.out.println(a.toString());
    }

    @Test
    public void get() throws IndexOutOfBounds {
        LinkedOrderedList a = new LinkedOrderedList();
        try{
            a.add(6);
            a.add(44);
            a.add(7);
            a.add(14);
        } catch (Duplicate duplicate) {
            duplicate.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing get()...");
        int getValue = (int) a.get(6);
        System.out.println("3 + " + getValue + " = " + (3 + getValue)); //Answer 9
    }

    @Test
    public void reset() {
        LinkedOrderedList a = new LinkedOrderedList();
        try{
            a.add(2);
            a.add(44);
        } catch (Duplicate duplicate) {
            duplicate.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing reset()...");
        a.reset();
        System.out.print("The position for lookup has been reset.");
    }

    @Test
    public void getNext() {
        LinkedOrderedList a = new LinkedOrderedList();
        try{
            a.add(18);
            a.add(22);
        } catch (Duplicate duplicate) {
            duplicate.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing getNext()...");
        System.out.println(a.toString());
        System.out.println("Next data element of 18 is: " + a.getNext(18));
    }

    @Test
    public void isEmpty() {
        LinkedOrderedList a = new LinkedOrderedList();
        System.out.println();
        System.out.println("Testing isEmpty()...");
        System.out.println("The Ordered List is empty: " + a.isEmpty());
    }

}