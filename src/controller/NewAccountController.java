package controller;

import Core.AccountList;
import Core.AcctDataTracker;
import Core.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import views.NewAccountCreated;
import views.RegisterDriver;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NewAccountController {

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    PasswordField password2;
    @FXML
    TextField profilePic;
    //profilePic is Restaurant List File
    @FXML
    Label failSamePassword;
    @FXML
    Label failFieldsNotComplete;
    @FXML
    Label failPasswordFormat;
    @FXML
    Label failUsernameExists;

    /**Create New User Account */
    public void createAccount() throws IOException {

        /** Validate Info */
        if (userName.getText().equals("") || password.getText().equals("") || password2.getText().equals("")
                || profilePic.getText().equals("")) {
            failFieldsNotComplete.setVisible(true);
        }

        if (!password.getText().equals(password2.getText())) {
            failSamePassword.setVisible(true);
        }

        if (!validatePassword(password.getText())) {
            failPasswordFormat.setVisible(true);
        }

        if (AccountList.getUsers().contains(userName.getText())) {
            failUsernameExists.setVisible(true);
        }

        if (!userName.getText().equals("") && !password.getText().equals("")
                && password.getText().equals(password2.getText())
                && validatePassword(password.getText())
                && !profilePic.getText().equals("")
                && !(AccountList.getUsers().contains(userName.getText()))
                )

        /**Create Profile Page and Add New User to local .dat file and MongoDB */ {
            new NewAccountCreated();
            User u = new User(userName.getText(), password.getText(), profilePic.getText());

            //Adds new user to IndexedList and updates .dat file
            try {
                AcctDataTracker.outputIndexedAccounts(u);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Adds user to AccountList .dat file
            //AccountList.getUsers().add(u);

        }

        //Update local .dat file for AccountList
        //try {
            //AcctDataTracker.outputAccounts(AccountList.getUsers());
        //} catch (IOException e) {
         //   e.printStackTrace();
        //}
    }

    /**
     * Validate Password: Must have 1 number, 1 upper case letter, 1 lower case
     * letter, 1 special character
     */
    public boolean validatePassword(String password) {
        boolean hasUpperLetter = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean strong = false;
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char x = password.charAt(i);
                if (Character.isUpperCase(x)) {

                    hasUpperLetter = true;
                } else if (Character.isLowerCase(x)) {

                    hasLowerCase = true;
                } else if (Character.isDigit(x)) {

                    hasDigit = true;
                } else if (!matcher.matches()) {

                    hasSpecial = true;
                }

                // Password strong, break the loop
                if (hasUpperLetter && hasLowerCase && hasDigit && hasSpecial) {

                    strong = true;
                    break;
                }

            }
            if (strong) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Open File Chooser for Picture
     */
    public void uploadProfilePic() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Find Profile Picture");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(RegisterDriver.getRegisterStage());
        System.out.println(selectedFile.getPath());
        profilePic.appendText(selectedFile.getPath());
    }

    public void createFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Restaurant List File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(RegisterDriver.getRegisterStage());
        profilePic.appendText(selectedFile.getPath());
        /*   if (selectedFile != null) {
            mainStage.display(selectedFile);
        }*/
    }
}

