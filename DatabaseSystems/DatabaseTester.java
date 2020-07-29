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

    public static void testUpdateEmployee() {
        Employee eModel = new Employee();
        eModel.setFirstName("George");
        eModel.setLastName("smith");
        eModel.setPhoneNumber("(888)888-8888");
        eModel.setEmployeeID(3);

        DatabaseManager.updateEmployee(eModel);
    }

    public static void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("George");
        customer.setLastName("smith");
        customer.setPhoneNumber("(888)888-8888");
        customer.setCustomerID(3);

        DatabaseManager.updateCustomer(customer);
    }

    public static void testUpdatePet() {
        Pet pet = new Pet();
        pet.setPetID(2);
        pet.setCustomerID(2);
        pet.setName("Kitten");
        pet.setSpecies("Dog");
        pet.setBreed("Dalmation");
        pet.setBirthday("1999-01-19");
        pet.setGender("Female");

        DatabaseManager.updatePet(pet);
    }
}