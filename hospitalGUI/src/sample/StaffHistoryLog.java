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

public class StaffHistoryLog {
    String name, date, reason, symptoms, prescriptions;
    public StaffHistoryLog(String name, String date, String reason, String symptoms, String prescriptions) {
        this.name = name;
        this.date = date;
        this.reason = reason;
        this.symptoms = symptoms;
        this.prescriptions = prescriptions;
    }

    public String getName(){ return name; }
    public String getDate(){
        return date;
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

    public void setName(){
        this.name = name;
    }
    public void setDate(){
        this.date = date;
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
