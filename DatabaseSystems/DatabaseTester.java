package DatabaseSystems;

import java.util.ArrayList;

import API.*;

public class DatabaseTester {

    public static void testUserAdditionWithEmployee() {
        Employee eModel = new Employee();
        eModel.setFirstName("Joe");
        eModel.setLastName("smith");
        eModel.setPhoneNumber("(292)444-1213");

        DatabaseManager.addEmployee(eModel);
    }

    public static void testUserAdditionWithCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("catt");
        customer.setLastName("cafasdft");
        customer.setPhoneNumber("(222)333-4444");

        DatabaseManager.addCustomer(customer);
    }

    public static void testUserAdditionWithPet() {
        Pet pet = new Pet();
        pet.setBirthday("1998-01-13");
        pet.setBreed("Calico");
        pet.setCustomerID(2);
        pet.setGender("Male");
        pet.setName("Brendan");
        pet.setPetID(2);
        pet.setSpecies("Cat");

        DatabaseManager.addPet(pet);
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

    public static void testPrintPets() {
        DatabaseManager.PrintPets();
    }
}