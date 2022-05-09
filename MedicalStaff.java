
public class MedicalStaff {
    //Variable Section
    private String name;
    private String staffID;
    //Variable Section end

    //Constructor
    public MedicalStaff(String nameOfStaff, String Id){
        this.name = nameOfStaff;
        staffID = Id;
    }
    public MedicalStaff(){
        this("","");
    }
    //Constructor end

    //Getter and Setter Section
    public String getName() {
        return name;
    }
    public String getStaffID(){
        return staffID;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Getter and Setter Section end

    //Custom String output
    @Override
    public String toString() {
        return getStaffID() + ", " + getName();
    }
    //Custom String output end
}
