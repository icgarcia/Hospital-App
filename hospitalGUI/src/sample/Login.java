package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    public Login(){

    }

    @FXML private Button loginButton;
    @FXML private Button regButton;
    @FXML private Label errorText;
    @FXML private TextField username;
    @FXML private PasswordField password;
    private int loginType = 0;
    public static String userN = "";
    public static String pass = "";
    public static int userID = -1;
    
    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }
    
    private void checkLogin() throws IOException{
        Main m = new Main();
        //if successful
        userN = username.getText().toString();
        pass = password.getText().toString();
        Connection connection = myConnection.getConnection();
        String sql = "SELECT username from userInfo WHERE username =  '" + userN + "'";
        try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        String sql1 = "SELECT password from userInfo WHERE password =  '" + pass + "'";
        if(rs.next())
             rs = statement.executeQuery(sql1);
             if(rs.next()) {
            	 String sql2 = "SELECT userID from userInfo WHERE username = '" + userN + "'";
            	 ResultSet rs1 = statement.executeQuery(sql2);
            	 while(rs1.next()) {
            		userID = rs1.getInt(1);
            	 }
            	 int type = -1;
            	 String sql3 = "SELECT userType from userInfo WHERE username = '" + userN + "'";
            	 ResultSet rs2 = statement.executeQuery(sql3);
            	 while(rs2.next()) {
            		type = rs2.getInt(1);
            	 }
            	 if (type == 1)
            		 m.changeScene("home.fxml");
            	 else if (type == 2)
            		 m.changeScene("staffHome.fxml");
            	 else
            		 System.out.println("BIG ERROR");
              }
         else {
                errorText.setText("Incorrect Username or Password!");
            }
         connection.close();
            }
        catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            }
    }
    
    @FXML
    private void userRegister(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("registerType.fxml");
    }
}
