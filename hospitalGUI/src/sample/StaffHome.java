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

public class StaffHome {
    public StaffHome(){

    }
    @FXML private Label checkOutText;
    @FXML private Button profileButton;
    @FXML private Button appointmentButton;
    @FXML private Button scheduleButton;
    @FXML private Button medHistoryButton;
    @FXML private Button doctorButton;
    @FXML private Button checkOutButton;
    @FXML private Button logOutButton;

    @FXML
    private void profilePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffProfile.fxml");
    }
    @FXML
    private void appointmentPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffAppt.fxml");
    }
    
    @FXML
    private void medicalHistoryPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffMedicalHistory.fxml");
    }
    
    
    @FXML
    private void signInPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }
}
