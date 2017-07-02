package Core;

import java.util.ArrayList;

public class AccountList {

    private static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        AccountList.users = users;
    }
}
