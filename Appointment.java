public class Appointment {
    //Field
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;
    private String description;
    private String doctorNotes;
    
    //Constructor
    public Appointment(Patient patient, Doctor doctor, String appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }
    public Appointment(Patient patient, Doctor doctor, String appointmentDate, String description, String doctorNotes) {
        this(patient, doctor, appointmentDate);
        this.description = description;
        this.doctorNotes = doctorNotes;
    }
    public Appointment(){
        this(new Patient(), new Doctor(),"","","");
    }

    //Get and Set
    public String getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDoctorNotes() {
        return doctorNotes;
    }
    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    //Use case Function
    


    
}
