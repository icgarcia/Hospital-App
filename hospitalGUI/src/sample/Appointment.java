package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Appointment {
    public Appointment(){

    }
    @FXML private Button homeButton, Button1, Button2, Button3, Button4, Button5 ,Button6, Button7, Button8, Button9, Button10, Button11, Button12;
    @FXML private DatePicker apptDate;
    @FXML private Label timeSlot;
    @FXML private Label confirmationText;
    private int time = 0;

    @FXML
    private void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("home.fxml");
    }
    
    @FXML
    private void confirmDate(ActionEvent event) throws IOException {
        apptDate.getValue();
        Connection con = myConnection.getConnection();
        if(!checkApp()) {
    		try {
    			Statement statement = con.createStatement();
    			int userID = Login.userID;
  
    		 	String sql = "INSERT INTO Appointment(appointmentDate,appointmentTime,userID) VALUES ('" + apptDate.getValue() + "'," + time + ", " + userID +  ")";  		
    		 	PreparedStatement ps = con.prepareStatement(sql);
    	        boolean tes = statement.execute(sql);
    	 }
    	 catch(SQLException e) {
    		 System.out.println("Error");
             e.printStackTrace();
    	 }
    		confirmationText.setStyle("-fx-text-fill: green");
        	confirmationText.setText("Appointment Confirmed!");
        }
        else {
        	confirmationText.setStyle("-fx-text-fill: red");
        	confirmationText.setText("Appointment failed.");
        }
        
    }
 
    @FXML
    private void timeSelect7(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 7 AM.");
        time = 7;
    }
    @FXML
    private void timeSelect8(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 8 AM.");
        time = 8;
    }
    @FXML
    private void timeSelect9(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 9 AM.");
        time = 9;
    }
    @FXML
    private void timeSelect10(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 10 AM.");
        time = 10;
    }
    @FXML
    private void timeSelect11(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 11 AM.");
        time = 11;
    }
    @FXML
    private void timeSelect12(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 12 AM.");
        time = 12;
    }
    @FXML
    private void timeSelect1(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 1 PM.");
        time = 1;
    }
    @FXML
    private void timeSelect2(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 2 PM.");
        time = 2;
    }
    @FXML
    private void timeSelect3(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 3 PM.");
        time = 3;
    }
    @FXML
    private void timeSelect4(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 4 PM.");
        time = 4;
    }
    @FXML
    private void timeSelect5(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 5 PM.");
        time = 5;
    }
    @FXML
    private void timeSelect6(ActionEvent event) throws IOException {
        timeSlot.setText("Your appointment will be at 6 PM.");
        time = 6;
    }
    
    private boolean checkApp() {
    	Connection con = myConnection.getConnection();
    	boolean a = false;
   		String sql = "SELECT appointmentDate from Appointment WHERE appointmentDate  = '" + apptDate.getValue() + "'";
	   	 try {
	         Statement statement = con.createStatement();
	         ResultSet rs = statement.executeQuery(sql);
	         String sql1 = "SELECT appointmentTime from Appointment WHERE appointmentTime = " + time;
	         if(rs.next())
	              rs = statement.executeQuery(sql1);
	              if(rs.next()) {
	                  a = true; 
	               }
	          else {
	                 a = false;
	             }
	          con.close();
	             }
	         catch (SQLException e) {
	             System.out.println("Error");
	             e.printStackTrace();
	             }
	   	 return a;
    }

}
