package API;

import java.util.ArrayList;
import DatabaseSystems.*;

public class CustomerManager {
    private ArrayList<Customer> customers;

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

    public void addCustomer(Customer customer) {
        customer.setCustomerID(DatabaseManager.addCustomer(customer));
        customers.add(customer);
    }

    public void addPetWithCustomerID(Pet pet, int customerID) {
        Customer customer = getCustomer(customerID);
        customer.addPet(pet);
    }

    public Customer getCustomer(String firstName, String lastName) {
        for (Customer customer : customers)
            if (firstName.equals(customer.getFirstName()) && lastName.equals(customer.getLastName()))
                return customer;

        Customer customer = new Customer();
        customer.setFirstName("ERROR");
        customer.setLastName("ERROR");
        return customer;
    }

    public Customer getCustomer(int customerID) {
        for (Customer customer : customers)
            if (customerID == customer.getCustomerID())
                return customer;

        Customer customer = new Customer();
        customer.setFirstName("ERROR");
        customer.setLastName("ERROR");
        return customer;
    }

    public void updateCustomer(int customerID, Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customerID == customers.get(i).getCustomerID()) {
                updatedCustomer.setCustomerID(customerID);
                customers.remove(i);
                customers.add(updatedCustomer);
                DatabaseManager.updateCustomer(updatedCustomer);
            }
        }
    }

    public void closeDatabase() {
        for (Customer customer : customers) {
            DatabaseManager.updateCustomer(customer);
            for (Pet pet : customer.getPets())
                DatabaseManager.updatePet(pet);
        }
    }

    public String toString() {
        String str = "Customer Data:\n";
        int index = 1;
        for (Customer customer : customers) {
            str += index + ".\n\t";
            str += customer.toString();
            index++;
        }
        return str;
    }
}