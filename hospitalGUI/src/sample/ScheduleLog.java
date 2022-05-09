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

public class ScheduleLog {
    String doctor, date, time, patient, reason;
    public ScheduleLog(String doctor, String date, String time, String patient, String reason) {
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.reason = reason;
    }

    public String getDoctor(){
        return doctor;
    }
    public String getDate(){ return date; }
    public String getTime(){
        return time;
    }
    public String getPatient(){
        return patient;
    }
    public String getReason(){
        return reason;
    }

    public void setDoctor(){
        this.doctor = doctor;
    }
    public void setDate(){
        this.date = date;
    }
    public void setTime(){
        this.time = time;
    }
    public void setPatient(){
        this.patient = patient;
    }
    public void setReason(){
        this.reason = reason;
    }
}
