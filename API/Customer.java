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
     * @param pet
     */
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    /**
     * removePet removes a pet from the customer.
     * 
     * @param petID
     */
    public void removePet(int petID) {
        for (int i = 0; i < pets.size(); i++)
            if (pets.get(i).petID == petID)
                pets.remove(i);
    }

    /**
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return ArrayList<Pet>
     */
    public ArrayList<Pet> getPets() {
        return pets;
    }

    /**
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
