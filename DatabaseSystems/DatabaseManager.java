package DatabaseSystems;

import API.*;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private static String url = "jdbc:mysql://160.153.41.196/VetCenter";
    private static String UUID = "F7i.2OPy$9.)=";
    private static String deviceID = "fhfwtd6ujd8m";

    /**
     * GetIncrementalEID will get and return the next available EmployeeID from the
     * database.
     * 
     * @return int
     */
    public static int getIncrementalEID() {
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

    /**
     * GetIncrementalCID will get and return the next available CustomerID from the
     * database.
     * 
     * @return int
     */
    public static int getIncrementalCID() {
        try {
            String query = "SELECT * FROM Customer ORDER BY CID DESC LIMIT 1";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                return rSet.getInt("CID") + 1;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * addEmployee will create a query to create a new employee and send it to the
     * database
     * 
     * @param employee
     */
    public static void addEmployee(Employee employee) {
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

    /**
     * addCustomer will create a query to create a new customer and send it to the
     * database
     * 
     * @param customer
     */
    public static void addCustomer(Customer customer) {
        try {
            String prepareStatement = "insert into Customer (CID, FirstName, LastName,PhoneNumber) values (?, ?, ?, ?)";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            statement.setInt(1, DatabaseManager.getIncrementalCID());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getPhoneNumber());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getEmployeesFromDatabase is a function that will read the data from the
     * database and get all of the employee data to return
     * 
     * @return ArrayList<Employee>
     */
    public static ArrayList<Employee> getEmployeesFromDatabase() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
            String query = "select * from Employee";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rSet.getInt("EID"));
                employee.setFirstName(rSet.getString("FirstName"));
                employee.setLastName(rSet.getString("LastName"));
                employee.setPhoneNumber(rSet.getString("PhoneNumber"));

                employees.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * getCustomersFromDatabase is a function that will read the data from the
     * database and get all of the customer data to return
     * 
     * @return ArrayList<Customer>
     */
    public static ArrayList<Customer> getCustomersFromDatabase() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            String query = "select * from Customer";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rSet.getInt("CID"));
                customer.setFirstName(rSet.getString("FirstName"));
                customer.setLastName(rSet.getString("LastName"));
                customer.setPhoneNumber(rSet.getString("PhoneNumber"));

                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    /**
     * printEmployees will read the Employee data from the database and print all of
     * the employees
     */
    public static void printEmployees() {
        try {
            String query = "select * from Employee";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rSet.getInt("EID"));
                employee.setFirstName(rSet.getString("FirstName"));
                employee.setLastName(rSet.getString("LastName"));
                employee.setPhoneNumber(rSet.getString("PhoneNumber"));

                System.out.println(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * printCustomers will read the customer data from the database and print all of
     * the customers
     */
    public static void printCustomers() {
        try {
            String query = "select * from Customers";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rSet.getInt("CID"));
                customer.setFirstName(rSet.getString("FirstName"));
                customer.setLastName(rSet.getString("LastName"));
                customer.setPhoneNumber(rSet.getString("PhoneNumber"));

                System.out.println(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * printPets will read the pets data from the database and print all of the pets
     */
    public static void PrintPets() {

    }
}