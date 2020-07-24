
import java.sql.*;

public class DatabaseManager {
    private String username = "CSUser";
    private String password = "CS1234";

    DatabaseManager() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", username, password);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery("select * from Employee");

            while (rSet.next()) {
                System.out.println(rSet.getString("EmployeeID") + ", " + rSet.getString("FirstName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}