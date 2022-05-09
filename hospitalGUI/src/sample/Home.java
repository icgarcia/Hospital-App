package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class Home {
    public Home(){

    }
    @FXML private Label checkInText;
    @FXML private Button profileButton;
    @FXML private Button medHistoryButton;
    @FXML private Button appointmentButton;
    @FXML private Button logOutButton;

    @FXML
    private void profilePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("profile.fxml");
    }

    @FXML
    private void medicalHistoryPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("medicalHistory.fxml");
    }

    @FXML
    private void appointmentPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("appointment.fxml");
    }

    @FXML
    private void signInPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }
}
