package System.API;

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

    public Employee(String firstName, String lastName, String phoneNumber, String startDate, int weeklyHours,
            int scheduledHours) {
        this.startDate = startDate;
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

    /**
     * @return int
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @return String
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @return int
     */
    public int getWeeklyHours() {
        return weeklyHours;
    }

    /**
     * @return int
     */
    public int getScheduledHours() {
        return scheduledHours;
    }

    /**
     * @param scheduledHours Integer to update ScheduledHours.
     */
    public void setScheduledHours(int scheduledHours) {
        this.scheduledHours = scheduledHours;
    }

    /**
     * @param weeklyHours Integer to update WeeklyHours.
     */
    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    /**
     * @param employeeID Integer to update EmployeeID.
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @param startDate String to update startDate.
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return String
     */
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