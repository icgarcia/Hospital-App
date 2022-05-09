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

public class RegisterType {
    public RegisterType() {

    }
    @FXML private Button loginButton;
    @FXML private Button patientButton;
    @FXML private Button staffButton;
    @FXML private Button doctorButton;

    //if regType == 1 patient acc, else if regType == 2 staff acc
    public static int regType = 0;

    @FXML
    private void patientReg(ActionEvent event) throws IOException {
        Main m = new Main();
        regType = 1;
        m.changeScene("register.fxml");
    }
    @FXML
    private void staffReg(ActionEvent event) throws IOException {
        Main m = new Main();
        regType = 2;
        m.changeScene("register.fxml");
    }
    @FXML
    private void loginPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }
}
