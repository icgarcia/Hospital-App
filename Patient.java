import java.util.ArrayList;

public class Patient{

    private String name;
    private int age;
    private int weight;
    private String address;
    private String gender;
    private String birthDate;
    private String phoneNumber;
    private ArrayList<String> conditions = new ArrayList<String>();
    private ArrayList<String> prescriptions = new ArrayList<String>();

    public Patient(String pName, int pAge, int pWeight, String pAddress, String pGender, String pBirthDate, String pPhoneNumber;){
      name = pName;
      age = pAge;
      weight = pWeight;
      address = pAddress;
      gender = pGender;
      birthDate = pBirthDate;
      phoneNumber = pPhoneNumber;
    }
    public Patient(){
        //sets up a John Doe account if no info given
        this("John Doe","18","140","123 Street", "M", "01/01/2001", "0123456789");
    }

    public String getName(){
      return name;
    }
    public int getAge(){
      return age;
    }
    public int getWeight(){
      return weight;
    }
    public String getAddress(){
      return address;
    }
    public String getGender(){
      return gender;
    }
    public String getBirthDate(){
      return birthDate;
    }
    public String getPhoneNumber(){
      return phoneNumber;
    }
    public ArrayList<String> getConditions(){
      return conditions;
    }
    public ArrayList<String> getPrescriptions(){
      return prescriptions
    }
    public void setName(String newName){
      this.name = newName;
    }
    public void setAge(Int newAge){
      this.age = newAge;
    }
    public void setWeight(Int newWeight){
      this.weight = newWeight;
    }
    public void setAddress(String newAddress){
      this.address = newAddress;
    }
    public void setGender(String newGender){
      this.gender = newGender;
    }
    public void setBirhDate(String newBirthDate){
      this.birthDate = newBirthDate;
    }
    public void setPhoneNumber(String newPhoneNumber){
      this.phoneNumber = newPhoneNumber;
    }
    public void setConditions(String newCondition){
      this.conditions.add(newCondition);
    }
    public void setPrescriptions(String newPrecription){
      this.prescriptions.add(newPrecription);
    }
}
