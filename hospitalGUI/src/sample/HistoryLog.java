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

public class HistoryLog {
    String date, doctor, reason, symptoms, prescriptions;
    public HistoryLog(String date, String doctor, String reason, String symptoms, String prescriptions) {
        this.date = date;
        this.doctor = doctor;
        this.reason = reason;
        this.symptoms = symptoms;
        this.prescriptions = prescriptions;
    }

    public String getDate(){ return date; }
    public String getDoctor(){
        return doctor;
    }
    public String getReason(){
        return reason;
    }
    public String getSymptoms(){
        return symptoms;
    }
    public String getPrescriptions(){
        return prescriptions;
    }

    public void setDate(){
        this.date = date;
    }
    public void setDoctor(){
        this.doctor = doctor;
    }
    public void setReason(){
        this.reason = reason;
    }
    public void setSymptoms(){
        this.symptoms = symptoms;
    }
    public void setPrescriptions(){
        this.prescriptions = prescriptions;
    }
}
