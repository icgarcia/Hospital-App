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

public class staffMedicalHistory implements Initializable {
	
	@FXML
	private TableView <StaffModelTable> table;
	@FXML
	private TableColumn<StaffModelTable,String> colPatient;
	@FXML
	private TableColumn<StaffModelTable,String> colDate;
	@FXML
	private TableColumn<StaffModelTable,String> colTime;

	
	ObservableList<StaffModelTable> oblist = FXCollections.observableArrayList();
	@Override
	public void initialize (URL location, ResourceBundle resources) {
		
		String timeAdjusted = "";
		Connection con = myConnection.getConnection();
		try {
			Statement statement = con.createStatement();
			Statement statement1 = con.createStatement();
			String sql = "SELECT * from Appointment ";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getInt("appointmentTime") <= 12 && rs.getInt("appointmentTime") >= 7)
					timeAdjusted = rs.getString("appointmentTime") + " AM";
				else
					timeAdjusted = rs.getString("appointmentTime") + " PM";
				int userN = Integer.parseInt(rs.getString("userID"));
				String sql1 = "Select name from userInfo WHERE userID = " + userN; 
				ResultSet rs1 = statement1.executeQuery(sql1);
				while(rs1.next())
					break;
				oblist.add(new StaffModelTable(rs1.getString("name"), rs.getString("appointmentDate"), timeAdjusted));
				
			}
		}
		catch(SQLException e) {
			System.out.println("Error");
            e.printStackTrace();
		}
		colPatient.setCellValueFactory(new PropertyValueFactory<>("name"));
		colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		table.setItems(oblist);
	}
	
    public staffMedicalHistory(){

    }
    @FXML
    private Button homeButton;
    

    @FXML
    private void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffHome.fxml");
    }
    
}
