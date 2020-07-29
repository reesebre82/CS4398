package API;

import java.util.ArrayList;
import DatabaseSystems.*;

public class CustomerManager {
    ArrayList<Customer> customers;

    public CustomerManager() {
        customers = DatabaseManager.getCustomersFromDatabase();

        ArrayList<Pet> pets = DatabaseManager.getPetsFromDatabase();

        for (Pet pet : pets) {
            for (Customer customer : customers) {
                if (customer.getCustomerID() == pet.getCustomerID())
                    customer.addPet(pet);
            }
        }
    }

    public Customer getCustomer(String firstName, String lastName) {
        for (Customer customer : customers)
            if (firstName.equals(customer.getFirstName()) && lastName.equals(customer.getLastName()))
                return customer;

        Customer customer = new Customer();
        customer.setFirstName("ERROR");
        customer.setLastName("ERROR");
        return new Customer();
    }

    public Customer getCustomer(int customerID) {
        for (Customer customer : customers)
            if (customerID == customer.getCustomerID())
                return customer;

        Customer customer = new Customer();
        customer.setFirstName("ERROR");
        customer.setLastName("ERROR");
        return new Customer();
    }

    public void updateCustomer(int customerID, Customer updatedCustomer) {
        for (Customer customer : customers) {
            if (customerID == customer.getCustomerID()) {
                updatedCustomer.setCustomerID(customerID);
                customers.remove(customer);
                customers.add(updatedCustomer);
                DatabaseManager.updateCustomer(updatedCustomer);
            }
        }
    }

    public void closeDatabase() {
        for (Customer customer : customers) {
            DatabaseManager.updateCustomer(customer);
        }
    }
}