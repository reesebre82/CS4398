package API;

public class Employee extends PersonModel {
    private int employeeID;
    private int weeklyHours;
    private int scheduledHours;
    private String startDate;

    public Employee() {
        startDate = "1900-01-01";
        firstName = "";
        lastName = "";
        phoneNumber = "(000)000-0000";
        weeklyHours = 0;
        scheduledHours = 0;
        employeeID = -1;
    }

    public Employee(String firstName, String lastName, String phoneNumber, int weeklyHours, int scheduledHours) {
        startDate = "1900-01-01";
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.weeklyHours = weeklyHours;
        this.scheduledHours = scheduledHours;
    }

    // Used to deep copy employee
    public Employee(Employee employee) {
        this.startDate = employee.getStartDate();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.phoneNumber = employee.getPhoneNumber();
        this.weeklyHours = employee.getWeeklyHours();
        this.scheduledHours = employee.getScheduledHours();
        this.employeeID = employee.getEmployeeID();
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public int getScheduledHours() {
        return scheduledHours;
    }

    public void setScheduledHours(int scheduledHours) {
        this.scheduledHours = scheduledHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String toString() {
        String str = "";
        str += "EID: ";
        str += employeeID + "\n\t";
        str += "First Name: ";
        str += firstName + "\n\t";
        str += "Last Name: ";
        str += lastName + "\n\t";
        str += "Phone Number: ";
        str += phoneNumber + "\n\t";
        str += "Start Date: ";
        str += startDate + "\n\t";
        str += "Weekly Hours: ";
        str += weeklyHours + "\n\t";
        str += "Scheduled hours: ";
        str += scheduledHours + "\n\t";
        str += "\n\n";
        return str;
    }
}