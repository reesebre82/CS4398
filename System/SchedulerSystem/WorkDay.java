package System.SchedulerSystem;

import System.API.*;
import java.util.ArrayList;

public class WorkDay {
    String dayOfWeek;
    int shiftHours;
    ArrayList<Employee> employees;

    WorkDay() {
        employees = new ArrayList<Employee>();
    }

    /**
     * addEmployee will add an employee to the work day and remove hours that the
     * employee will work from the total available hours.
     * 
     * @param employee Employee that will be added.
     * @param hours    Integer number of hours to be changed.
     */
    public void addEmployee(Employee employee, int hours) {
        employees.add(employee);
        shiftHours += hours;
    }

    /**
     * isFull will state if the day is full of employees.
     * 
     * @return boolean
     */
    public boolean isFull() {
        if (shiftHours <= 0)
            return true;
        return false;
    }

    /**
     * @return String
     */
    public String toString() {
        String str = "";
        for (Employee employee : employees) {
            str += "EID: ";
            str += employee.getEmployeeID() + "\n\t";
            str += "First Name: ";
            str += employee.getFirstName() + "\n\t";
            str += "Last Name: ";
            str += employee.getLastName() + "\n\t";
            str += "Phone Number: ";
            str += employee.getWeeklyHours() + "\n\t";
            str += "Scheduled hours: ";
            str += employee.getScheduledHours() + "\n\t";
            str += "\n\n";
        }

        str += "Hours Available: " + shiftHours;

        return str;
    }
}