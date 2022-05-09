public class Doctor extends MedicalStaff{
    //Variable Section
    private String specialty;
    private String room;
    private String phoneNumber;
    //Variable Section end

    //Constructor
    public Doctor(MedicalStaff staff, String docSpecialty, String docRoom, String docPhone){
        super(staff.getName(),staff.getStaffID());
        specialty = docSpecialty;
        room = docRoom;
        phoneNumber = docPhone;
    }
    public Doctor(){
        this(new MedicalStaff(),"","","");
    }
    //Constructor end

    //Getter and Setter Section
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //Getter and Setter Section end

    //Custom String output
    @Override
    public String toString() {
        return super.getStaffID()+ ", "+ super.getName() + ", " + getSpecialty()+ ", " + getRoom() + ", " + getPhoneNumber();
    }
    //Custom String output end
        

}
