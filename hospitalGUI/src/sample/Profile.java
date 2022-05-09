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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class Profile implements Initializable {
	public Profile() {

	}

	@FXML
	private Button homeButton;
	@FXML
	private Button editProfileButton;
	@FXML
	public Label name;
	@FXML
	public Label age;
	@FXML
	public Label gender;
	@FXML
	public Label weight;
	@FXML
	public Label height;
	@FXML
	public Label birthday;
	@FXML
	public Label phoneNumber;
	@FXML
	public Label address;

	@FXML

	private void homePage(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("home.fxml");
	}

	@FXML
	private void editProfilePage(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("editProfile.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		String nameD ="";
		String ageD ="";
		String genderD ="";
		String weightD ="";
		String heightD ="";
		String birthdayD ="";
		String phoneNumberD ="";
		String addressD ="";
		
		 Connection con = myConnection.getConnection();
		 try { 
			 Statement statement = con.createStatement(); 
			 String sql = "SELECT * from Patient WHERE userID =" + Login.userID ;
			 PreparedStatement ps = con.prepareStatement(sql); 
			 ResultSet rs = statement.executeQuery(sql);
			 	while(rs.next()) {
			 		ageD = rs.getString(2);
			 		genderD = rs.getString(3);
			 		weightD = rs.getString(4);
			 		heightD = rs.getString(5);
			 		birthdayD = rs.getString(6);
			 		phoneNumberD = rs.getString(7);
			 		addressD = rs.getString(8);
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
		age.setText(ageD);
		gender.setText(genderD);
		weight.setText(weightD);
		height.setText(heightD);
		birthday.setText(birthdayD);
		phoneNumber.setText(phoneNumberD);
		address.setText(addressD);

	}

}
