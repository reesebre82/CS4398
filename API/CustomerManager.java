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

    public String toString() {
        String str = "";
        int index = 1;
        for (Customer customer : customers) {
            str += index + ".\n\t";
            str += "CID: ";
            str += customer.getCustomerID() + "\n\t";
            str += "First Name: ";
            str += customer.getFirstName() + "\n\t";
            str += "Last Name: ";
            str += customer.getLastName() + "\n\t";
            str += "Phone Number: ";
            str += customer.getPhoneNumber() + "\n\t";
            if (customer.getPets().size() != 0) {
                str += "Pets:" + "\n\t" + "  ";
                char petIndex = 'a';
                for (Pet pet : customer.getPets()) {
                    str += petIndex + "." + "\n\t\t";
                    str += "PID: ";
                    str += pet.getPetID() + "\n\t\t";
                    str += "Name: ";
                    str += pet.getName() + "\n\t\t";
                    str += "Species: ";
                    str += pet.getSpecies() + "\n\t\t";
                    str += "Breed: ";
                    str += pet.getBreed() + "\n\t\t";
                    str += "Birthday: ";
                    str += pet.getBirthday() + "\n\t\t";
                    str += "Gender: ";
                    str += pet.getGender() + "\n\t" + "  ";
                    petIndex++;
                }
            }
            str += "\n";
            index++;
        }
        return str;
    }
}