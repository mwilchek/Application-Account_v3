package Core;

import dataStructures.IndexedList;

import java.io.*;

public class AcctDataTracker {

    /**
     * Creates a .dat file to save account data to refer back to for ArrayList
     */
    public static void outputAccounts(Object accounts) throws IOException {
        ObjectOutputStream output;
        output = new ObjectOutputStream(new FileOutputStream("accounts.dat"));
        output.writeObject(accounts);
        System.out.println("A full list of accounts for this application can be found under the location" +
                " where this program was saved.");
    }

    /**
     * Reads the .dat file for the ArrayList authentication
     */
    public static Object readAccounts() throws IOException, ClassNotFoundException {
        ObjectInputStream input;
        input = new ObjectInputStream(new FileInputStream("accounts.dat"));
        return input.readObject();
    }

    /**
     * Creates a separate .dat file to save account data to refer back to for IndexedList
     */
    public static void outputAccountsI(IndexedList<User> accounts) throws IOException {
        ObjectOutputStream output;
        output = new ObjectOutputStream(new FileOutputStream("accountsIndex.dat"));
        output.writeObject(accounts);
        System.out.println("A full list of accounts for this application can be found under the location " +
                "where this program was saved.");
    }

    /**
     * Update .dat file with new user info as an IndexedList
     */
    public static void outputIndexedAccounts(User user) throws Exception {
        IndexedList<User> list = new IndexedList<>();
        list.add(user);
        outputAccountsI(list);
    }

    /**
     * Read the .dat file and return an IndexedList with all of the .dat file data
     */
    public static IndexedList<User> readIndexedAccounts() throws Exception {
        ObjectInputStream input;
        IndexedList<User> list = new IndexedList<>();
        input = new ObjectInputStream(new FileInputStream("accountsIndex.dat"));
        return list = (IndexedList<User>) input.readObject();
    }
}
