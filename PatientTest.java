import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Patient{
  public static void main(String args[]){
    String url = "jdbc:sqlserver:sqlsrv\\sqlexpress;databaseName=MedicalOffice";
    String user = "sa"
    String password = ""

    String name;
    int age;
    int weight;
    String address;
    String gender;
    String birthDate;
    String phoneNumber;
    String conditions;
    String prescriptions;

    public Patient(){
      if user exists{
        try{
          Connecton conn = DriverManager.getConnection(url,user,password);
          String sql = "SELECT name FROM Patients";
          Statement statement = conn.createStatement();
          ResultSet result = statement.executeUpdateQuery(sql);

          String name = result.getString()
          //all of the info. need column names
          }

        } catch (SQLException e) {
          System.out.println("Oops, there's an error: ");
          e.printStackTrace();
      }

      else
        CreateAccount()//grab info from ui for parameters
    }
    public void CreateAccount(String name, int age, int weight, String address, String gender, String birthDate){
      try{
        Connecton conn = DriverManager.getConnection(url,user,password);
        String sql = "INSERT INTO Patients(names of columns) "
                    + "VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name)
        statement.setInt(2, age)
        statement.setInt(3,weight)
        statement.setString(4, address)
        statement.setSTring
        int rows = statement.executeUpdate(sql)
        if (rows > 0) {
          System.out.println("Success")
        }
        conn.close()
      } catch (SQLException e) {
        System.out.println("Oops, there's an error: ");
        e.printStackTrace();
      }
    }
    public void EditAccount(){
      try{
        Connecton conn = DriverManager.getConnection(url,user,password);
        String sql = "INSERT INTO Patients(names of columns) "
                    + "VALUES (name,age,weight,address,gender,birthDate)";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql)

        conn.close()
      } catch (SQLException e) {
        System.out.println("Oops, there's an error: ");
        e.printStackTrace();
      }
    }
    //schedule appointment
    //edit appointment
    // check in
  }
}
