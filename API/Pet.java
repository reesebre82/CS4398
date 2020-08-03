package API;

public class Pet {

    int petID;
    int customerID;
    String name;
    String species;
    String breed;
    String birthday;
    String gender;
    String comments;

    public Pet() {
        petID = customerID = -1;
        name = species = breed = gender = birthday = comments = "";
    }

    public Pet(int petID, int customerID, String name, String species, String breed, String birthday, String gender,
            String comments) {
        this.petID = petID;
        this.customerID = customerID;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.gender = gender;
        this.birthday = birthday;
        this.comments = comments;
    }

    public String toString() {
        String str = "";
        str += "PID: ";
        str += petID + "\n\t\t";
        str += "Name: ";
        str += name + "\n\t\t";
        str += "Species: ";
        str += species + "\n\t\t";
        str += "Breed: ";
        str += breed + "\n\t\t";
        str += "Birthday: ";
        str += birthday + "\n\t\t";
        str += "Gender: ";
        str += gender + "\n\t\t";
        str += "Comments: ";
        str += comments + "\n\t" + "  ";
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

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getComments() {
        return comments;
    }

    /* End of Getters and Setters */
}