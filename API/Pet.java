package API;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pet {

    int petID;
    int customerID;
    String name;
    String species;
    String breed;
    String birthday;
    String gender;

    public Pet() {
        petID = customerID = -1;
        name = species = breed = gender = birthday = "";
    }

    public Pet(int petID, int customerID, String name, String species, String breed, String birthday, String gender) {
        this.petID = petID;
        this.customerID = customerID;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String toString() {
        String str = "";
        str += Integer.toString(petID) + " ";
        str += Integer.toString(customerID) + " ";
        str += name + " ";
        str += species + " ";
        str += breed + " ";
        str += birthday + " ";
        str += gender;
        return str;
    }

    /* Start of Getters and Setters */

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getBreed() {
        return breed;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getPetID() {
        return petID;
    }

    public String getSpecies() {
        return species;
    }

    /* End of Getters and Setters */
}