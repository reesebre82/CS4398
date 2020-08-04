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

    /**
     * addCustomer adds a customer to the database and ArrayList
     * 
     * @param customer Customer Customer to be added.
     */
    public void addCustomer(Customer customer) {
        customer.setCustomerID(DatabaseManager.addCustomer(customer));
        customers.add(customer);
    }

    /**
     * addPetWithCustomerID will add a pet to the customer with the given customerID
     * 
     * @param pet        Pet Pet to be added.
     * @param customerID Integer CID for customer to add the pet to.
     */
    public void addPetWithCustomerID(Pet pet, int customerID) {
        Customer customer = getCustomer(customerID);
        customer.addPet(pet);
    }

    /**
     * removePet will remove a pet with the PetID from the customer with the
     * CustomerID CID
     * 
     * @param PID Integer PID for pet to be removed.
     * @param CID Integer CID for Customer who's pet will be removed.
     */
    public void removePet(int PID, int CID) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerID() == CID) {
                ArrayList<Pet> pets = customers.get(i).getPets();
                for (int j = 0; j < pets.size(); j++) {
                    if (pets.get(j).getPetID() == PID) {
                        DatabaseManager.removePet(PID);
                        customers.get(i).removePet(PID);
                    }
                }
            }
        }
    }

    /**
     * removeCustomer will remove a customer with a given customerID
     * 
     * @param CID Integer CID for customer to be removed.
     */
    public void removeCustomer(int CID) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerID() == CID) {
                DatabaseManager.removeCustomer(CID);
                customers.remove(i);
            }
        }
    }

    /**
     * getCustomer will return a customer with a given first and last name
     * 
     * @param firstName String first name for customer to be returned.
     * @param lastName  String last name for customer to be returned.
     * @return Customer
     */
    public Customer getCustomer(String firstName, String lastName) {
        for (Customer customer : customers)
            if (firstName.equals(customer.getFirstName()) && lastName.equals(customer.getLastName()))
                return customer;

        Customer customer = new Customer();
        customer.setFirstName("ERROR");
        customer.setLastName("ERROR");
        return customer;
    }

    /**
     * getCustomer will return a customer with a given customerID
     * 
     * @param customerID Integer CID for customer to be returned.
     * @return Customer
     */
    public Customer getCustomer(int customerID) {
        for (Customer customer : customers)
            if (customerID == customer.getCustomerID())
                return customer;

        Customer customer = new Customer();
        customer.setFirstName("ERROR");
        customer.setLastName("ERROR");
        return customer;
    }

    /**
     * updateCustomer will update a customer in the ArrayList and then update it in
     * the database.
     * 
     * @param customerID      Integer CID for customer to be updated.
     * @param updatedCustomer Customer customer information to update customer with
     *                        CID to.
     */
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

    /**
     * closeDatabase will update all of the customer data that may not have been
     * updated.
     */
    public void closeDatabase() {
        for (Customer customer : customers) {
            DatabaseManager.updateCustomer(customer);
            for (Pet pet : customer.getPets())
                DatabaseManager.updatePet(pet);
        }
    }

    /**
     * @return String
     */
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