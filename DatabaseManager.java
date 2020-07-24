
import java.sql.*;

public class DatabaseManager {

    static void AddEmployee() {
        String url = "jdbc:mysql://160.153.41.196/VetCenter";
        String UUID = "F7i.2OPy$9.)=";
        String deviceID = "fhfwtd6ujd8m";
        try {
            String query = "insert into Employee (EmployeeID, FirstName, LastName, PhoneNumber) values (2, 'Joey', 'Reese', '5129000702')";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            statement.executeUpdate(query);

            System.out.println("Query Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void PrintEmployees() {
        String url = "jdbc:mysql://160.153.41.196/VetCenter";
        String UUID = "F7i.2OPy$9.)=";
        String deviceID = "fhfwtd6ujd8m";
        try {
            String query = "select * from Employee";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                System.out.print(rSet.getString("EmployeeID") + ": " + rSet.getString("FirstName"));
                System.out.println(" " + rSet.getString("LastName") + " " + rSet.getString("phoneNumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}