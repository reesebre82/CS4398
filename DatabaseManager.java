
import java.sql.*;

public class DatabaseManager {
    private static String url = "jdbc:mysql://160.153.41.196/VetCenter";
    private static String UUID = "F7i.2OPy$9.)=";
    private static String deviceID = "fhfwtd6ujd8m";

    static int getIncrementalEID() {
        try {
            String query = "SELECT * FROM Employee ORDER BY EID DESC LIMIT 1";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                return rSet.getInt("EID") + 1;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    static void AddEmployee(Employee employee) {
        try {
            String prepareStatement = "insert into Employee (EID, FirstName, LastName, PhoneNumber) values (?, ?, ?, ?)";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            statement.setInt(1, DatabaseManager.getIncrementalEID());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getPhoneNumber());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void PrintEmployees() {
        try {
            String query = "select * from Employee";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                System.out.print(rSet.getString("EID") + ": " + rSet.getString("FirstName"));
                System.out.println(" " + rSet.getString("LastName") + " " + rSet.getString("phoneNumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}