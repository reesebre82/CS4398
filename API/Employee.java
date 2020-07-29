package API;

public class Employee extends PersonModel {
    private int employeeID;

    // private _ scheduleRestrictions;
    // private _ mySchedule; // Schedule class not implemented yet
    private String startDate;

    public Employee() {
        startDate = "1900-01-01";
        firstName = "";
        lastName = "";
        phoneNumber = "(000)000-0000";
        employeeID = -1;
    }

    public Employee(String firstName, String lastName, String phoneNumber) {
        startDate = "1900-01-01";
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String toString() {
        String str = "";
        str += Integer.toString(employeeID) + " ";
        str += firstName + " ";
        str += lastName + " ";
        str += phoneNumber + " ";
        return str;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> brendan
