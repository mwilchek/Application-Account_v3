package views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAccountCreated {


    public NewAccountCreated() throws IOException {
        Stage registrationStage = new Stage();
        Parent registrationView = FXMLLoader.load(getClass().getResource("AccountMade.fxml"));
        registrationStage.setTitle("Account Created");
        registrationStage.setScene(new Scene(registrationView, 721, 355));
        registrationStage.show();
    }
}
