package views;
/* Java class file that calls to show and load User Profile */
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileDriver {
    private static Stage profileStage = new Stage();

    public ProfileDriver() throws IOException {
        Stage profileStage = new Stage();
        Parent profileView = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
        profileStage.setTitle("Restaurant Information");
        Scene registerScene = new Scene(profileView, 600, 600);

        profileStage.setScene(registerScene);
        profileStage.show();
    }

    public static Stage getProfileStage() {
        return profileStage;
    }

}
