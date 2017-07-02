package Core;

import dataStructures.IndexedList;

/**
 * Created by Matt on 6/18/2017.
 */
public class AccountIndexedList<U extends User> {

    private static IndexedList<User> users = new IndexedList<>();

    public static IndexedList getUsers() {
        return users;
    }

    public static void setUsers(IndexedList<User> users) {
        AccountIndexedList.users = users;
    }
}
