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
    protected static int getIncrementalEID() {
        int max = 1;
        try {
            String query = "SELECT * FROM Employee";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                max = Math.max(rSet.getInt("EID"), max);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return max + 1;
    }

    /**
     * GetIncrementalCID will get and return the next available CustomerID from the
     * database.
     * 
     * @return int
     */
    protected static int getIncrementalCID() {
        int max = 1;
        try {
            String query = "SELECT * FROM Customer";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                max = Math.max(rSet.getInt("CID"), max);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return max + 1;
    }

    /**
     * GetIncrementalPID will get and return the next available PetID from the
     * database.
     * 
     * @return int
     */
    protected static int getIncrementalPID() {
        int max = 1;
        try {
            String query = "SELECT * FROM Pets";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                max = Math.max(rSet.getInt("PID"), max);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return max + 1;
    }

    /**
     * addEmployee will create a query to create a new employee and send it to the
     * database
     * 
     * @param employee
     * @return EID
     */
    public static int addEmployee(Employee employee) {
        try {
            String prepareStatement = "insert into Employee (EID, FirstName, LastName, PhoneNumber, HoursWeekly, ScheduledHours, StartDate)";
            prepareStatement += " values (?, ?, ?, ?, ?, ?,?)";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            int incrementalEID = DatabaseManager.getIncrementalEID();

            statement.setInt(1, incrementalEID);
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getPhoneNumber());
            statement.setInt(5, employee.getWeeklyHours());
            statement.setInt(6, employee.getScheduledHours());
            statement.setString(7, employee.getStartDate());

            statement.executeUpdate();

            return incrementalEID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * addPet will create a query to create a new pet and send it to the database
     * 
     * @param pet
     * @return PID
     */
    public static int addPet(Pet pet) {
        try {
            String prepareStatement = "insert into Pets (PID, CID, Name, Species, Breed, Birthday, Gender, Comments) values (?, ?, ?, ?, ?, ?, ?, ?)";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            int incrementalPID = DatabaseManager.getIncrementalPID();

            statement.setInt(1, incrementalPID);
            statement.setInt(2, pet.getCustomerID());
            statement.setString(3, pet.getName());
            statement.setString(4, pet.getSpecies());
            statement.setString(5, pet.getBreed());
            statement.setString(6, pet.getBirthday());
            statement.setString(7, pet.getGender());
            statement.setString(8, pet.getComments());

            statement.executeUpdate();

            return incrementalPID;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * addCustomer will create a query to create a new customer and send it to the
     * database
     * 
     * @param customer
     * @return CID
     */
    public static int addCustomer(Customer customer) {
        try {
            String prepareStatement = "insert into Customer (CID, FirstName, LastName,PhoneNumber) values (?, ?, ?, ?)";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            int incrementalCID = DatabaseManager.getIncrementalCID();

            statement.setInt(1, incrementalCID);
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getPhoneNumber());

            statement.executeUpdate();

            return incrementalCID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
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
                employee.setWeeklyHours(rSet.getInt("HoursWeekly"));
                employee.setScheduledHours(rSet.getInt("ScheduledHours"));
                employee.setStartDate(rSet.getString("StartDate"));

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
     * getPetsFromDatabase is a function that will read the data from the database
     * and get all of the pets data to return
     * 
     * @return ArrayList<Pets>
     */
    public static ArrayList<Pet> getPetsFromDatabase() {
        ArrayList<Pet> pets = new ArrayList<Pet>();
        try {
            String query = "select * from Pets";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                Pet pet = new Pet();
                pet.setBirthday(rSet.getString("Birthday"));
                pet.setBreed(rSet.getString("Breed"));
                pet.setCustomerID(rSet.getInt("CID"));
                pet.setPetID(rSet.getInt("PID"));
                pet.setName(rSet.getString("Name"));
                pet.setGender(rSet.getString("Gender"));
                pet.setSpecies(rSet.getString("Species"));
                pet.setComments(rSet.getString("Comments"));

                pets.add(pet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pets;
    }

    /**
     * updateEmployee will update a employee record in the database
     * 
     * @param employee
     */
    public static void updateEmployee(Employee employee) {
        try {
            String prepareStatement = "UPDATE Employee ";
            prepareStatement += "Set ";
            prepareStatement += "FirstName = ?, ";
            prepareStatement += "LastName = ?, ";
            prepareStatement += "PhoneNumber = ?, ";
            prepareStatement += "HoursWeekly = ?, ";
            prepareStatement += "ScheduledHours = ?, ";
            prepareStatement += "StartDate = ? ";
            prepareStatement += "WHERE EID = ?";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getPhoneNumber());
            statement.setInt(4, employee.getWeeklyHours());
            statement.setInt(5, employee.getScheduledHours());
            statement.setString(6, employee.getStartDate());
            statement.setInt(7, employee.getEmployeeID());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * updateCustomer will update a customer record in the database
     * 
     * @param customer
     */
    public static void updateCustomer(Customer customer) {
        try {
            String prepareStatement = "UPDATE Customer ";
            prepareStatement += "Set ";
            prepareStatement += "FirstName = ?, ";
            prepareStatement += "LastName = ?, ";
            prepareStatement += "PhoneNumber = ? ";
            prepareStatement += "WHERE CID = ?";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getPhoneNumber());
            statement.setInt(4, customer.getCustomerID());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * updatePet will update a Pet record in the database
     * 
     * @param pet
     */
    public static void updatePet(Pet pet) {
        try {
            String prepareStatement = "UPDATE Pets ";
            prepareStatement += "Set ";
            prepareStatement += "Name = ?, ";
            prepareStatement += "Species = ?, ";
            prepareStatement += "Breed = ?, ";
            prepareStatement += "Birthday = ?, ";
            prepareStatement += "Gender = ?, ";
            prepareStatement += "Comments = ? ";
            prepareStatement += "WHERE PID = ?";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies());
            statement.setString(3, pet.getBreed());
            statement.setString(4, pet.getBirthday());
            statement.setString(5, pet.getGender());
            statement.setString(6, pet.getComments());
            statement.setInt(7, pet.getPetID());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param EID
     */
    public static void removeEmployee(int EID) {
        try {
            String prepareStatement = "DELETE FROM Employee ";
            prepareStatement += "WHERE EID = ?";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            statement.setInt(1, EID);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param CID
     */
    public static void removeCustomer(int CID) {
        try {
            String prepareStatement = "DELETE FROM Customer ";
            prepareStatement += "WHERE CID = ?";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            statement.setInt(1, CID);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param PID
     */
    public static void removePet(int PID) {
        try {
            String prepareStatement = "DELETE FROM Pets ";
            prepareStatement += "WHERE PID = ?";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            PreparedStatement statement = conn.prepareStatement(prepareStatement);

            statement.setInt(1, PID);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
                employee.setWeeklyHours(rSet.getInt("HoursWeekly"));
                employee.setScheduledHours(rSet.getInt("ScheduledHours"));
                employee.setStartDate(rSet.getString("StartDate"));

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
        try {
            String query = "select * from Pets";

            Connection conn = DriverManager.getConnection(url, deviceID, UUID);
            Statement statement = conn.createStatement();

            ResultSet rSet = statement.executeQuery(query);

            while (rSet.next()) {
                Pet pet = new Pet();
                pet.setBirthday(rSet.getString("Birthday"));
                pet.setBreed(rSet.getString("Breed"));
                pet.setCustomerID(rSet.getInt("CID"));
                pet.setPetID(rSet.getInt("PID"));
                pet.setName(rSet.getString("Name"));
                pet.setGender(rSet.getString("Gender"));
                pet.setSpecies(rSet.getString("Species"));
                pet.setComments(rSet.getString("Comments"));

                System.out.println(pet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}