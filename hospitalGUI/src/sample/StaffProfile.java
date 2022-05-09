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

public class StaffProfile implements Initializable {
    public StaffProfile() {

    }
    @FXML private Button homeButton;
    @FXML private Button editProfileButton;
    @FXML private Label name;
    @FXML private Label specialty;
    @FXML private Label phoneNumber;
    @FXML private Label room;

    @FXML
    private void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffHome.fxml");
    }
    @FXML
    private void editProfilePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("editStaffProfile.fxml");
        
    }
    public void initialize(URL url, ResourceBundle rb) {

		String nameD ="";
		String phoneNumberD ="";
		String roomD ="";
		String specialtyD = "";
		
		 Connection con = myConnection.getConnection();
		 try { 
			 Statement statement = con.createStatement(); 
			 String sql = "SELECT * from Doctor WHERE userID =" + Login.userID ;
			 PreparedStatement ps = con.prepareStatement(sql); 
			 ResultSet rs = statement.executeQuery(sql);
			 	while(rs.next()) {
			 		specialtyD = rs.getString(2);
			 		roomD = rs.getString(3);
			 		phoneNumberD = rs.getString(4);
			 	}
			 	String sql1 = "SELECT name from userInfo WHERE userID =" + Login.userID ;
			 	ResultSet rs1 = statement.executeQuery(sql1);
			 	while(rs1.next()) 
			 		nameD = rs1.getString(1);
		 
		 } 
		 catch(SQLException e) { 
			 System.out.println("Error"); 
			 }
		 
		name.setText(nameD);
		phoneNumber.setText(phoneNumberD);
		specialty.setText(specialtyD);
		room.setText(roomD);

	}
}
