package API;

import java.util.ArrayList;

public class Customer extends PersonModel {

    ArrayList<Pet> pets;
    int customerID;

    public Customer() {
        super();
        customerID = -1;
    }

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        customerID = -1;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String toString() {
        String str = "";
        str += Integer.toString(customerID) + " ";
        str += firstName + " ";
        str += lastName + " ";
        str += phoneNumber + " ";
        return str;
    }
}