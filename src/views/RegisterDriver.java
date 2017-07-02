package views;

/* Java class file that calls to show and load New Account GUI page */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterDriver {
    private static Stage registerStage = new Stage();

    public RegisterDriver() throws IOException {
    	Stage registerStage = new Stage();
        Parent registerView = FXMLLoader.load(getClass().getResource("NewAccount.fxml"));
        registerStage.setTitle("New Account Page");
        Scene registerScene = new Scene(registerView, 700, 600);

        registerStage.setScene(registerScene);
        registerStage.show();
    }

    public static Stage getRegisterStage() {
        return registerStage;
    }


}
