package API;

import java.util.ArrayList;

public class Customer extends PersonModel {

    private ArrayList<Pet> pets;
    private int customerID;

    public Customer() {
        super();
        pets = new ArrayList<Pet>();
        customerID = -1;
    }

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        pets = new ArrayList<Pet>();
        customerID = -1;
    }

    /**
     * addPet adds a pet to the customer.
     * 
     * @param pet Pet to be added.
     */
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    /**
     * removePet removes a pet from the customer.
     * 
     * @param petID integer to set petID to.
     */
    public void removePet(int petID) {
        for (int i = 0; i < pets.size(); i++)
            if (pets.get(i).petID == petID)
                pets.remove(i);
    }

    /**
     * setCustomerID will update the CID.
     * 
     * @param customerID integer to set CustomerID to.
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * getPets will return the pets for the customer.
     * 
     * @return ArrayList<Pet>
     */
    public ArrayList<Pet> getPets() {
        return pets;
    }

    /**
     * getCustomerID will return the CID.
     * 
     * @return int
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @return String
     */
    public String toString() {
        String str = "";
        str += "CID: ";
        str += customerID + "\n\t";
        str += "First Name: ";
        str += firstName + "\n\t";
        str += "Last Name: ";
        str += lastName + "\n\t";
        str += "Phone Number: ";
        str += phoneNumber + "\n\t";

        if (pets.size() != 0) {
            str += "Pets:" + "\n\t" + "  ";
            char petIndex = 'a';
            for (Pet pet : pets) {
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
                str += pet.getGender() + "\n\t\t";
                str += "Comments: ";
                str += pet.getComments() + "\n\t" + "  ";
                petIndex++;
            }
        }
        str += "\n\n";
        return str;
    }
}
