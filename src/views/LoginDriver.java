package views;
/**
 * @author Matt Wilchek
 * @use This application should only be tested by Matt Wilchek and Professor Tanes Kanchanawanchai
 * Any testers outside of these 2 individuals will be in violation of this license. Matt Wilchek reserves all rights
 * to this files and related project files under /src
 * */
import Core.*;
import dataStructures.IndexedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mongoDB.MongoDB;

import java.io.IOException;
import java.util.ArrayList;

import static Core.AcctDataTracker.readIndexedAccounts;

public class LoginDriver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MongoDB.setMongoConnection();
        loadUserAccounts();
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        primaryStage.setTitle("Application Login");
        primaryStage.setScene(new Scene(root, 726, 300));
        primaryStage.show();
    }

    public void loadUserAccounts() throws Exception {
        try {
            // Validate for existing account from IndexedList .dat file
            IndexedList<User> list = readIndexedAccounts();
            AccountIndexedList.setUsers(list);

            // Validate for existing account from array .dat file
            //AccountList.setUsers((ArrayList<User>) AcctDataTracker.readAccounts());
        } catch (IOException e) {
            System.err.print("Cannot open Accounts file.");
        } catch (ClassNotFoundException e) {
            System.err.print("Error: error in class file for reading Accounts.");
        }
    }

}
