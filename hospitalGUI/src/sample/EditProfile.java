package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EditProfile implements Initializable{
    public EditProfile() {

    }
    @FXML private Button homeButton;
    @FXML private Button profileButton;
    @FXML private Button confirmButton;
    
    @FXML private TextField nameField;
    @FXML private TextField addressField;
    @FXML private TextField phoneNumberField;
    @FXML private TextField ageField;
    @FXML private TextField genderField;
    @FXML private TextField heightField;
    @FXML private TextField weightField;
    @FXML private TextField birthdayField;
    @FXML private Label errorText;
  

    @FXML
    private void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("home.fxml");
    }
    @FXML
    private void profilePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("profile.fxml");
    }
    @FXML
    private void confirmChanges(ActionEvent event) throws IOException {
        Main m = new Main();
        
        if(nameField.getText().isEmpty() || addressField.getText().isEmpty() || phoneNumberField.getText().isEmpty()|| ageField.getText().isEmpty()
        		||genderField.getText().isEmpty() || heightField.getText().isEmpty() ||weightField.getText().isEmpty()|| birthdayField.getText().isEmpty())
        {
            errorText.setText("Please fill out all fields");
        }
        else
        {
      
        	Connection con = myConnection.getConnection();
        	try {
        		 	Statement statement = con.createStatement();
        		 	
        		 	String sql = "UPDATE userInfo set name =' " + nameField.getText() + "' WHERE userID = " + Login.userID;
        		 	String sql2 = "UPDATE Patient Set age = " + Integer.parseInt(ageField.getText()) + ", gender = '" + genderField.getText() +"', weight = '" + weightField.getText() +
        		 			"', height = '" + heightField.getText() + "', birthday = '"+ birthdayField.getText() + "', phoneNumber  = '"+ phoneNumberField.getText() +
        		 			"', address = '" + addressField.getText() + "' WHERE userID = " + Login.userID ;
        		 	PreparedStatement ps = con.prepareStatement(sql2);
        	        Boolean rs = statement.execute(sql2);
        	        Boolean rs1 = statement.execute(sql);
        	       
        	 }
        	 catch(SQLException e) {
        		 System.out.println("Error");
	             e.printStackTrace();
        	 }
        m.changeScene("profile.fxml");
        }
    }

    @Override
    public void initialize (URL url, ResourceBundle rb) {
    	
    }
}
