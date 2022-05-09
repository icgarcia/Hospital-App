package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class EditDoctor {
    public EditDoctor(){

    }
    ObservableList<String> doctorDropDownList = FXCollections.observableArrayList("Dr. Jones", "Dr Howard", "Dr. Pines", "Dr. Lee", "Dr. Ramirez");
    @FXML ComboBox doctorDropDownBox;

    ObservableList<String> patientDropDownList = FXCollections.observableArrayList("John Smith", "Jane Doe", "Ross Jones");
    @FXML ComboBox patientDropDownBox;

    @FXML private Button confirmButton;
    @FXML private Label confirmationText;
    @FXML private Label errorText;

    @FXML
    private void initialize(){
        doctorDropDownBox.setValue("Select Doctor");
        doctorDropDownBox.setItems(doctorDropDownList);
        patientDropDownBox.setValue("Select Patient");
        patientDropDownBox.setItems(patientDropDownList);
    }

    @FXML
    private void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffHome.fxml");
    }

    @FXML
    private void confirmDoctor(ActionEvent event) throws IOException {
        if (doctorDropDownBox.getValue()!="Select Doctor" && patientDropDownBox.getValue() != "Select Patient") {
            confirmationText.setText("Doctor Successfully Assigned!");
            errorText.setText("");
        }
        else {
            errorText.setText("Please fill in all fields.");
            confirmationText.setText("");
        }
    }
}
