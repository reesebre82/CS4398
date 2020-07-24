package DatabaseSystems;

import java.util.ArrayList;

import API.*;

public class DatabaseTester {

    public static void testUserAdditionWithEmployee() {
        Employee eModel = new Employee();
        eModel.setFirstName("John");
        eModel.setLastName("Murphy");
        eModel.setPhoneNumber("(732)545-7591");

        DatabaseManager.addEmployee(eModel);
    }

    public static void testUserAdditionWithCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("catt");
        customer.setLastName("cafasdft");
        customer.setPhoneNumber("(222)333-4444");

        DatabaseManager.addCustomer(customer);
    }

    public static void getEID() {
        System.out.println(DatabaseManager.getIncrementalEID());
    }

    public static void testGetEmployees() {
        ArrayList<Employee> employees = DatabaseManager.getEmployeesFromDatabase();

        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeID() + " " + employee.getFirstName() + " " + employee.getLastName()
                    + " " + employee.getPhoneNumber());
        }
    }

    public static void testGetCustomers() {
        ArrayList<Customer> customers = DatabaseManager.getCustomersFromDatabase();

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}