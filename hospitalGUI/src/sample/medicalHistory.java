package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.fxml.Initializable;

public class medicalHistory implements Initializable {
	
	@FXML
	private TableView <ModelTable> table;
	@FXML
	private TableColumn<ModelTable,String> colDate;
	@FXML
	private TableColumn<ModelTable,String> colTime;
	
	
	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
	@Override
	public void initialize (URL location, ResourceBundle resources) {
		
		String timeAdjusted = "";
		Connection con = myConnection.getConnection();
		try {
			Statement statement = con.createStatement();
			String sql = "SELECT * from Appointment WHERE userID =  '" + Login.userID + "'";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getInt("appointmentTime") <= 12 && rs.getInt("appointmentTime") >= 7)
					timeAdjusted = rs.getString("appointmentTime") + " AM";
				else
					timeAdjusted = rs.getString("appointmentTime") + " PM";
				oblist.add(new ModelTable(rs.getString("appointmentDate"), timeAdjusted));
			}
		}
		catch(SQLException e) {
			System.out.println("Error");
            e.printStackTrace();
		}
		colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		table.setItems(oblist);
	}
    public medicalHistory(){

    }
    @FXML
    private Button homeButton;
    

    @FXML
    private void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("home.fxml");
    }
    
}
