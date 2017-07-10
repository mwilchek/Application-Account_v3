package controller;

import Core.AccountIndexedList;
import Core.Restaurant;
import Core.User;
import dataStructures.IndexedList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    /**Authentication attempt with AccountIndexedList */
    public void authenticate() throws Exception {
        IndexedList<User> list = readIndexedAccounts();
        AccountIndexedList.setUsers(list);
        boolean login = false;
        for (int i = 0; i < AccountIndexedList.getUsers().size(); i++) {
            User accountFound = (User) AccountIndexedList.getUsers().get(i);
            if (userName.getText().equals(accountFound.getUserName()) && password.getText().equals(accountFound.getPassword())) {
                System.out.println("Account information accepted.");
                restaurant = new Restaurant(accountFound.getPhoto()); //gets data file list of restaurants
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