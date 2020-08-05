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

    /**
     * setBirthday will update the birthday.
     * 
     * @param birthday String to update birthday.
     */
    /* Start of Getters and Setters */

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * setBreed will update the breed.
     * 
     * @param breed String to update breed.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * setCustomerID will update the CustomerID.
     * 
     * @param customerID Integer to update CustomerID.
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * setName will update the name.
     * 
     * @param name String to update name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setGender will update the gender.
     * 
     * @param gender String to update Gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * setPetID will update the PID.
     * 
     * @param petID Integer to update PetID.
     */
    public void setPetID(int petID) {
        this.petID = petID;
    }

    /**
     * setSpecies will update species.
     * 
     * @param species String to update species.
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * setComments will update comments.
     * 
     * @param comments String to update comments.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * getBirthday will return the birthday.
     * 
     * @return String
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * getBreed will return the breed.
     * 
     * @return String
     */
    public String getBreed() {
        return breed;
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
     * getName will return the name.
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * getGender will return the gender.
     * 
     * @return String
     */
    public String getGender() {
        return gender;
    }

    /**
     * getPetID will return the PId.
     * 
     * @return int
     */
    public int getPetID() {
        return petID;
    }

    /**
     * getSpecies will return the species.
     * 
     * @return String
     */
    public String getSpecies() {
        return species;
    }

    /**
     * getComments will return the comments.
     * 
     * @return String
     */
    public String getComments() {
        return comments;
    }

    /* End of Getters and Setters */

    /**
     * @return String
     */
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
}