public class Employee extends PersonModel {
    private int employeeID;

    // private _ scheduleRestrictions;
    // private _ mySchedule; // Schedule class not implemented yet
    private int startDate[];

    Employee() {
        startDate = new int[3];
        firstName = "";
        lastName = "";
        phoneNumber = "(000)000-0000";
        employeeID = -1;
    }

    Employee(String firstName, String lastName, String phoneNumber) {
        startDate = new int[3];
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int[] getStartDate() {
        return startDate;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setStartDate(int[] startDate) {
        this.startDate = startDate;
    }
}
