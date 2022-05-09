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
import java.sql.*;

public class Register {
    public Register() {

    }
    //name.getText()  email.getText() username.getText()  password.getText());
    @FXML private Button createAccButton;
    @FXML private Button loginButton;
    @FXML private Label errorText;
    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField phoneNumber;
    @FXML private TextField username;
    @FXML private PasswordField password;

    public void createAcc(ActionEvent event) throws IOException {
        checkRegistration();
    }

    private void checkRegistration() throws IOException {
        Main m = new Main();
        if(username.getText().isEmpty() || password.getText().isEmpty() || name.getText().isEmpty()|| email.getText().isEmpty()||phoneNumber.getText().isEmpty())
        {
            errorText.setText("Please fill out all fields");
        }
        else
        {
        	if(!checkApp()) {
        	Connection con = myConnection.getConnection();
        	try {
        		 	Statement statement = con.createStatement();
        		 	String sql1 = "SELECT userID from userInfo";
        		 	ResultSet rs1 = statement.executeQuery(sql1);
        		 	String userID = "-1";
        		 	while(rs1.next()) {
        		 		userID = rs1.getString("UserID");
        		 	}
        		 	int userNum = Integer.parseInt(userID) + 1;
       
        		 	String sql = "INSERT INTO userInfo(userID, username, password, userType, name) VALUES (" + userNum + ",'" + username.getText() + "','"+ password.getText() +"'," + RegisterType.regType + ",'" + name.getText()+ "')" ;
        		 	PreparedStatement ps = con.prepareStatement(sql);
        	        boolean rs = statement.execute(sql);
        	        
        	        if(RegisterType.regType == 1) {
	        	        String sql2 = "INSERT INTO Patient(userID, phoneNumber) VALUES(" + userNum + ", '" + phoneNumber.getText() + "')";
	        	        boolean rs2 = statement.execute(sql2);
        	        }
        	        else if(RegisterType.regType == 2) {
        	        	String sql2 = "INSERT INTO Doctor(userID, phoneNumber) VALUES(" + userNum + ", '" + phoneNumber.getText() + "')";
	        	        boolean rs2 = statement.execute(sql2);
        	        }
        	        
        	        Login.userID = userNum;
        	 }
        	 catch(SQLException e) {
        		 System.out.println("Error");
	             e.printStackTrace();
        	 }
        	
        	
        	if(RegisterType.regType == 1)
        		m.changeScene("home.fxml");
        	else if(RegisterType.regType == 2)
        		m.changeScene("staffHome.fxml");
        	else
        		System.out.println("BIG ERROR");
        	}
        		
        }
    }

    @FXML
    private void loginPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login.fxml");
    }
    
    private boolean checkApp() {
    	Connection con = myConnection.getConnection();
    	boolean a = false;
   		String sql = "SELECT username from userInfo WHERE username  = '" + username.getText() + "'";
	   	 try {
	         Statement statement = con.createStatement();
	         ResultSet rs = statement.executeQuery(sql);
	       
	         if(rs.next()) {
	                  a = true; 
	                  errorText.setText("Username already taken.");
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
