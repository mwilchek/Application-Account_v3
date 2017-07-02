package controller;

import Core.AccountList;
import Core.AcctDataTracker;
import Core.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
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

import static mongoDB.MongoDB.addUserToMongoDB;

public class NewAccountController {
    ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    PasswordField password2;
    @FXML
    TextField email;
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField dob;
    @FXML
    ChoiceBox gender;
    @FXML
    TextField ssn;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField profilePic;
    @FXML
    Label failSamePassword;
    @FXML
    Label failEmailFormat;
    @FXML
    Label failFieldsNotComplete;
    @FXML
    Label failPasswordFormat;
    @FXML
    Label failUsernameExists;

    @FXML
    private void initialize() {
        gender.setItems(genderList);
    }

    /**
     * Create New User Account
     */
    public void createAccount() throws IOException {

        /** Validate Info */
        if (firstName.getText().equals("") || lastName.getText().equals("") || dob.getText().equals("")
                || gender.getSelectionModel().getSelectedItem().toString().equals("") || userName.getText().equals("") || password.getText().equals("")) {
            failFieldsNotComplete.setVisible(true);
        }

        if (!email.getText().matches("\\w+@\\w+\\.\\w+")) {
            failEmailFormat.setVisible(true);
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


        if (!firstName.getText().equals("") && !lastName.getText().equals("") && !dob.getText().equals("")
                && !gender.getSelectionModel().getSelectedItem().equals(null) && !userName.getText().equals("") && !password.getText().equals("")
                && password.getText().equals(password2.getText())
                && validatePassword(password.getText())
                && email.getText().matches("\\w+@\\w+\\.\\w+")
                && !(AccountList.getUsers().contains(userName.getText()))
                )

        /**Create Profile Page and Add New User to local .dat file and MongoDB */ {
            new NewAccountCreated();
            User u = new User(firstName.getText(), lastName.getText(), dob.getText(), gender.getSelectionModel().getSelectedItem().toString(), userName.getText(), email.getText(), phoneNumber.getText(), password.getText(), profilePic.getText());

            //Adds new user to IndexedList and updates .dat file
            try {
                AcctDataTracker.outputIndexedAccounts(u);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Adds user to AccountList .dat file
            //AccountList.getUsers().add(u);

            //Adds user to Mongo Database
            addUserToMongoDB(u);
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
}

