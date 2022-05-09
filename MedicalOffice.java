import java.util.LinkedHashMap;
import java.util.Map;

public class MedicalOffice{
    //Variable Section
    private String name;
    private String phoneNumber;
    private String address;
    Map<String,MedicalStaff> mapOfStaff;
    Map<MedicalStaff,Doctor> mapOfDoctor;
    Map<String,Patient> mapOfPatient;
    private int staffNumber;
    private int initialID;
    
    //Variable Section end
    
    //Constructor
    public MedicalOffice(String nameOfOffice, String phoneOfOffice, String addressOfOffice){
        name = nameOfOffice;
        phoneNumber = phoneOfOffice;
        address = addressOfOffice;
        staffNumber = 0;
        initialID = 1000;

        mapOfStaff = new LinkedHashMap<String,MedicalStaff>();
        mapOfDoctor = new LinkedHashMap<MedicalStaff,Doctor>();
    }
    public MedicalOffice(){
        this("","","");
    }
    //Constructor end

    //Getter and Setter Section
    public String getName(){
        return this.name;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getAddress(){
        return this.address;
    }
    public void setName(String input){
        this.name = input;
    }
    public void setPhoneNumber(String input){
        this.phoneNumber = input;
    }
    public void setAddress(String input){
        this.address = input;
    }
    //Getter and Setter Section end

//Use case Functions
    //add functions
    public MedicalStaff addStaff(String nameOfStaff){
        String id = Integer.toString(initialID+staffNumber);
        mapOfStaff.put(id, new MedicalStaff(nameOfStaff,id));
        staffNumber++;
        return mapOfStaff.get(id);
    }
    public Doctor addDoctor(String id, String specialty, String room, String phone){
        MedicalStaff staff = mapOfStaff.get(id);
        mapOfDoctor.put(staff, new Doctor(staff, specialty, room, phone));
        return mapOfDoctor.get(staff);
    }
    public Patient addPatient(String pName, int pAge, int pWeight, String pAddress, String pGender, String pBirthDate, String pPhoneNumber){
        mapOfPatient(pName,new Patient(pName,pAge,pWeight,pAddress,pGender,pBirthDate,pPhoneNumber));
        return mapOfDoctor.get(pName);
    }
    //Find function
    public MedicalStaff findStaffbyID(String id){
        return mapOfStaff.get(id);
    }
    public MedicalStaff findStaffbyName(String name){
        for(String key : mapOfStaff.keySet()){
            if (mapOfStaff.get(key).getName() == name){
                return mapOfStaff.get(key);
            }
        }
        return null;
    }
    public Patient findPatientbyName(String name){
        return mapOfPatient.get(name);
    }
    public Doctor findDoctorbyID(String id){
        return mapOfDoctor.get(findStaffbyID(id));
    }
    public Doctor findDoctorbyName(String name){
        return mapOfDoctor.get(findDoctorbyName(name));
    }
    //Use case Functions end

    //Custom String output
    @Override
    public String toString() {
        return getName() + ", " + getPhoneNumber()+ ", " + getAddress();
    }
    //Custom String output end

}