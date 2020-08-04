package API;

public abstract class PersonModel {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;

    /**
     * setFirstName will update the first name.
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * setLastName will update the last name.
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * setPhoneNumber will update the phoneNumber.
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * getFirstName will return the firstName.
     * 
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getLastName will return the lastName.
     * 
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * getPhoneNumber will return the phoneNumber.
     * 
     * @return String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}