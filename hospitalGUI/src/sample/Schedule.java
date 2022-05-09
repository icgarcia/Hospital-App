package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class Schedule {
    public Schedule(){

    }

    @FXML
    private TableView<ScheduleLog> tableView;

    @FXML
    private TableColumn<ScheduleLog, String> doctor;

    @FXML
    private TableColumn<ScheduleLog, String> date;

    @FXML
    private TableColumn<ScheduleLog, String> time;

    @FXML
    private TableColumn<ScheduleLog, String> patient;

    @FXML
    private TableColumn<ScheduleLog, String> reason;

    ObservableList<ScheduleLog> list = FXCollections.observableArrayList(
            new ScheduleLog("Dr. Howard", "6/5/21", "2 PM", "Alex Hernandez", "Physical"),
            new ScheduleLog("Dr. Lee", "6/6/21", "5 PM", "Jane Doe", "Throat Infection"),
            new ScheduleLog("Dr. Ramirez", "7/13/21", "11 AM", "James Johnson", "Chest Pain")
    );

    public void initialize(){
        doctor.setCellValueFactory(new PropertyValueFactory<ScheduleLog, String>("Doctor"));
        date.setCellValueFactory(new PropertyValueFactory<ScheduleLog, String>("Date"));
        time.setCellValueFactory(new PropertyValueFactory<ScheduleLog, String>("Time"));
        patient.setCellValueFactory(new PropertyValueFactory<ScheduleLog, String>("Patient"));
        reason.setCellValueFactory(new PropertyValueFactory<ScheduleLog, String>("Reason"));

        tableView.setItems(list);
    }


    @FXML
    private void staffHomePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("staffHome.fxml");
    }

}
