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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EditStaffProfile {
    public EditStaffProfile() {

    }
    @FXML private Button homeButton;
    @FXML private Button profileButton;
    @FXML private Button confirmButton;
    @FXML private TextField nameField;
    @FXML private TextField specialtyField;
    @FXML private TextField roomField;
    @FXML private TextField phoneField;
    @FXML private Label errorText;

    @FXML
    private void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffHome.fxml");
    }
    @FXML
    private void profilePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffProfile.fxml");
    }
    @FXML
    private void confirmChanges(ActionEvent event) throws IOException{
    	Main m = new Main();
    	
    	  if(nameField.getText().isEmpty() || specialtyField.getText().isEmpty() || roomField.getText().isEmpty()|| phoneField.getText().isEmpty())
          {
              errorText.setText("Please fill out all fields");
          }
          else
          {
        
          	Connection con = myConnection.getConnection();
          	try {
          		 	Statement statement = con.createStatement();
          		 	String sql = "UPDATE userInfo set name =' " + nameField.getText() + "' WHERE userID = " + Login.userID;
        		 	String sql2 = "UPDATE Doctor Set specialty = '" + specialtyField.getText() +"', room = '" + roomField.getText() +
        		 			"', phoneNumber = '" + phoneField.getText() + "' WHERE userID = " + Login.userID ;
        		 	PreparedStatement ps = con.prepareStatement(sql2);
        	        Boolean rs = statement.execute(sql2);
        	        Boolean rs1 = statement.execute(sql);
        	       
        	 }
        	 catch(SQLException e) {
        		 System.out.println("Error");
	             e.printStackTrace();
        	 }
          	m.changeScene("staffProfile.fxml");
          }
    }
}
