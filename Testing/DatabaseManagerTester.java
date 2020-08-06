package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;
import System.API.*;
import System.DatabaseSystems.*;

/**
 * DatabaseManagerTester
 */
public class DatabaseManagerTester {

    @Test
    public void testAddEmployee() {
        ArrayList<Employee> employees = DatabaseManager.getEmployeesFromDatabase();

        int largest = -1;
        for (int i = 0; i < employees.size(); i++)
            largest = Math.max(largest, employees.get(i).getEmployeeID());

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Parker");
        employee.setPhoneNumber("(909)909-0909");
        employee.setScheduledHours(0);
        employee.setStartDate("01-13-1998");
        employee.setWeeklyHours(40);
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));

        ArrayList<Employee> newEmployees = DatabaseManager.getEmployeesFromDatabase();

        assertEquals(employees.size() + 1, newEmployees.size());
    }

    @Test
    public void testAddEmployee2() {
        Employee employee = new Employee();
        employee.setFirstName("Peter");
        employee.setLastName("Johnson");
        employee.setPhoneNumber("(123)321-1234");
        employee.setScheduledHours(0);
        employee.setStartDate("01-13-1998");
        employee.setWeeklyHours(40);
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));

        ArrayList<Employee> employees = DatabaseManager.getEmployeesFromDatabase();
        boolean found = false;
        for (Employee e : employees) {
            if (e.getEmployeeID() == employee.getEmployeeID()) {
                found = true;
                break;
            }
        }

        assertEquals(true, found);
    }

    @Test
    public void testAddPet() {
        ArrayList<Pet> pets = DatabaseManager.getPetsFromDatabase();

        int largest = -1;
        for (int i = 0; i < pets.size(); i++)
            largest = Math.max(largest, pets.get(i).getPetID());

        Pet pet = new Pet();
        pet.setBirthday("1-13-1998");
        pet.setBreed("Dog");
        pet.setCustomerID(1);
        pet.setComments("something new");
        pet.setGender("Spade");
        pet.setName("KITTY");
        pet.setSpecies("Domestic Short hair");
        pet.setPetID(DatabaseManager.addPet(pet));

        ArrayList<Pet> newPets = DatabaseManager.getPetsFromDatabase();

        assertEquals(pets.size() + 1, newPets.size());
    }

    @Test
    public void testAddPet2() {
        Pet pet = new Pet();
        pet.setBirthday("1-13-1998");
        pet.setBreed("Bird");
        pet.setCustomerID(1);
        pet.setComments("something also which is new");
        pet.setGender("Male");
        pet.setName("Flappy");
        pet.setSpecies("Pelican");
        pet.setPetID(DatabaseManager.addPet(pet));

        ArrayList<Pet> pets = DatabaseManager.getPetsFromDatabase();

        boolean found = false;
        for (Pet p : pets) {
            if (p.getPetID() == pet.getPetID()) {
                found = true;
                break;
            }
        }

        assertEquals(true, found);
    }

    @Test
    public void testAddCustomer() {
        ArrayList<Customer> customers = DatabaseManager.getCustomersFromDatabase();

        int largest = -1;
        for (int i = 0; i < customers.size(); i++)
            largest = Math.max(largest, customers.get(i).getCustomerID());

        Customer customer = new Customer();
        customer.setFirstName("Harrison");
        customer.setLastName("Harold");
        customer.setPhoneNumber("(989)747-8765");
        customer.setCustomerID(DatabaseManager.addCustomer(customer));

        ArrayList<Customer> newCustomers = DatabaseManager.getCustomersFromDatabase();

        assertEquals(customers.size() + 1, newCustomers.size());
    }

    @Test
    public void testAddCustomer2() {
        Customer customer = new Customer();
        customer.setFirstName("Bill");
        customer.setLastName("Murphy");
        customer.setPhoneNumber("(123)123-1234");
        customer.setCustomerID(DatabaseManager.addCustomer(customer));

        ArrayList<Customer> customers = DatabaseManager.getCustomersFromDatabase();

        boolean found = false;
        for (Customer c : customers) {
            if (c.getCustomerID() == customer.getCustomerID()) {
                found = true;
                break;
            }
        }

        assertEquals(true, found);
    }

    @Test
    public void testGetEmployees() {
        ArrayList<Employee> employees = DatabaseManager.getEmployeesFromDatabase();
        assertNotEquals(0, employees.size());
    }

    @Test
    public void testGetCustomers() {
        ArrayList<Customer> customers = DatabaseManager.getCustomersFromDatabase();
        assertNotEquals(0, customers.size());
    }

    @Test
    public void testGetPets() {
        ArrayList<Pet> pets = DatabaseManager.getPetsFromDatabase();
        assertNotEquals(0, pets.size());
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Brendan");
        employee.setLastName("Reese");
        employee.setPhoneNumber("(512)900-0702");
        employee.setScheduledHours(0);
        employee.setWeeklyHours(0);
        employee.setStartDate("1-13-1998");
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));

        employee.setFirstName("Joey");
        employee.setLastName("Galardia");
        employee.setPhoneNumber("(987)789-9876");
        employee.setScheduledHours(0);
        employee.setWeeklyHours(40);

        DatabaseManager.updateEmployee(employee);

        ArrayList<Employee> employees = DatabaseManager.getEmployeesFromDatabase();
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == employee.getEmployeeID())
                index = i;
        }

        assertEquals(employees.get(index).getFirstName(), employee.getFirstName());
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Brendan");
        customer.setLastName("Reese");
        customer.setPhoneNumber("(512)900-0702");
        customer.setCustomerID(DatabaseManager.addCustomer(customer));

        customer.setFirstName("Bill");
        customer.setLastName("Hader");
        customer.setPhoneNumber("(987)789-9876");

        DatabaseManager.updateCustomer(customer);

        ArrayList<Customer> customers = DatabaseManager.getCustomersFromDatabase();
        int index = 0;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerID() == customer.getCustomerID())
                index = i;
        }

        assertEquals(customers.get(index).getFirstName(), customer.getFirstName());
    }

    @Test
    public void testUpdatePet() {
        Pet pet = new Pet();
        pet.setName("Brendan");
        pet.setBirthday("1-13-1998");
        pet.setComments("unknown");
        pet.setCustomerID(1);
        pet.setBreed("dog");
        pet.setGender("male");
        pet.setSpecies("maltese");
        pet.setPetID(DatabaseManager.addPet(pet));

        pet.setBreed("parakeet");
        pet.setComments("New comments");
        pet.setCustomerID(2);
        pet.setGender("Female");
        pet.setName("Tweety");
        pet.setSpecies("bird");

        DatabaseManager.updatePet(pet);

        ArrayList<Pet> pets = DatabaseManager.getPetsFromDatabase();
        int index = 0;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getPetID() == pet.getPetID())
                index = i;
        }

        assertEquals(pets.get(index).getName(), pet.getName());
    }

    @Test
    public void testRemoveEmployee() {
        ArrayList<Employee> employees = DatabaseManager.getEmployeesFromDatabase();
        Employee employee = new Employee();
        employee.setFirstName("Brendan");
        employee.setLastName("Reese");
        employee.setPhoneNumber("(512)900-0702");
        employee.setScheduledHours(0);
        employee.setWeeklyHours(0);
        employee.setStartDate("1-13-1998");
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));

        DatabaseManager.removeEmployee(employee.getEmployeeID());
        ArrayList<Employee> newEmployees = DatabaseManager.getEmployeesFromDatabase();

        assertEquals(employees.size(), newEmployees.size());
    }

    @Test
    public void testRemoveCustomer() {
        ArrayList<Customer> customers = DatabaseManager.getCustomersFromDatabase();
        Customer customer = new Customer();
        customer.setFirstName("Brendan");
        customer.setLastName("Reese");
        customer.setPhoneNumber("(512)900-0702");
        customer.setCustomerID(DatabaseManager.addCustomer(customer));

        DatabaseManager.removeCustomer(customer.getCustomerID());
        ArrayList<Customer> newCustomers = DatabaseManager.getCustomersFromDatabase();

        assertEquals(customers.size(), newCustomers.size());
    }

    @Test
    public void testRemovePet() {
        ArrayList<Pet> pets = DatabaseManager.getPetsFromDatabase();
        Pet pet = new Pet();
        pet.setName("Brendan");
        pet.setBirthday("1-13-1998");
        pet.setComments("unknown");
        pet.setCustomerID(1);
        pet.setBreed("dog");
        pet.setGender("male");
        pet.setSpecies("maltese");
        pet.setPetID(DatabaseManager.addPet(pet));

        DatabaseManager.removePet(pet.getPetID());
        ArrayList<Pet> newPets = DatabaseManager.getPetsFromDatabase();

        assertEquals(pets.size(), newPets.size());
    }
}