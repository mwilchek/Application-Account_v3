package controller;

import Core.AccountIndexedList;
import Core.Restaurant;
import Core.User;
import dataStructures.IndexedList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mongoDB.MongoDB;
import views.RegisterDriver;
import views.RestaurantListDriver;

import java.io.IOException;

import static Core.AcctDataTracker.readIndexedAccounts;

public class LoginController {
    public static Restaurant restaurant;

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    Label failAuthentication;

    public void openRegister() throws IOException {
        System.out.println("Opening Registration...");
        new RegisterDriver();
    }

    /**
     * Check login credentials from local MongoDB
     */
    public void mongoAuthenticate() throws IOException {
        if (MongoDB.doesUsernameExist(userName.getText())) {
            User user = MongoDB.getUser(userName.getText());
            System.out.println("MongoDB Authentication Check:");
            System.out.println(user.toString());
            if (password.getText().equals(user.getEmail())) { // For some odd reason user.getPassword return the
                                                              // phone number and user.getEmail returns the password
                System.out.println("Account information accepted.");
                //profile = new ProfileInfo(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getGender(), user.getDob(), user.getPhoto());
                //new ProfileDriver();
                restaurant = new Restaurant();
                new RestaurantListDriver();
                System.out.println("welcome" + " " + userName.getText());

            } else {
                failAuthentication.setVisible(true);
            }
        }
    }

    /**
     * Authentication attempt with AccountIndexedList
     */
    public void authenticate() throws Exception {
        IndexedList<User> list = readIndexedAccounts();
        AccountIndexedList.setUsers(list);
        boolean login = false;
        for (int i = 0; i < AccountIndexedList.getUsers().size(); i++) {
            User accountFound = (User) AccountIndexedList.getUsers().get(i);
            if (userName.getText().equals(accountFound.getUserName()) && password.getText().equals(accountFound.getPassword())) {
                System.out.println("Account information accepted.");
                //profile = new ProfileInfo(accountFound.getFirstName(), accountFound.getLastName(), accountFound.getEmail(), accountFound.getPhone(), accountFound.getGender(), accountFound.getDob(), accountFound.getPhoto());
                //new ProfileDriver();
                new RestaurantListDriver();
                System.out.println("welcome" + " " + userName.getText());
                login = true;
                break;
            }
        }
        if (!login)
            failAuthentication.setVisible(true);
    }


    /**Original Authentication with AccountList (Array)
     *
     //Check login credentials from local .dat file from ArrayList
     public void authenticate() throws IOException {
     //Loop through AccountList to validate if it exists
     //replacing AccountList.getUsers() with AccountIndexed
     for (int i = 0; i < AccountList.getUsers().size(); i++) {
     //Compare userName and password from user input to each username and password from AccountList

     if (userName.getText().equals(AccountList.getUsers().get(i).getUserName())
     && password.getText().equals(AccountList.getUsers().get(i).getPassword())) {
     System.out.println("Account information accepted.");
     profile = new ProfileInfo(AccountList.getUsers().get(i).getFirstName(), AccountList.getUsers().get(i).getLastName(), AccountList.getUsers().get(i).getEmail(), AccountList.getUsers().get(i).getPhone(), AccountList.getUsers().get(i).getGender(), AccountList.getUsers().get(i).getDob(), AccountList.getUsers().get(i).getPhoto());
     new ProfileDriver();
     System.out.println("welcome" + " " + userName.getText() );
     break;
     } else {
     failAuthentication.setVisible(true);
     }
     }
     }
     */

}