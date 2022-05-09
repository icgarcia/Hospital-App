public class OfficeAssistant extends MedicalStaff{
    //Variable Section
    private String position;
    //Variable Section end

    //Constructor
    public OfficeAssistant(MedicalStaff staff, String staff_position){
        super(staff.getName(),staff.getStaffID());
        position = staff_position;
    }
    public OfficeAssistant(){
        this(new MedicalStaff(),"");
    }
    //Constructor end

    //Getter and Setter Section
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    //Getter and Setter Section end

    //Custom String output
    @Override
    public String toString() {
        return super.getName() + ", " + getPosition();
    }
    //Custom String output end


}
