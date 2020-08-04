package SchedulerSystem;

import API.*;
import java.util.ArrayList;

public class WorkDay {
    String dayOfWeek;
    int shiftHours;
    ArrayList<Employee> employees;

    WorkDay() {
        employees = new ArrayList<Employee>();
    }

    /**
     * @param employee Employee to be added to the work day
     * @param hours    Integer hours to be removed from the work day.
     */
    public void addEmployee(Employee employee, int hours) {
        employees.add(employee);
        shiftHours += hours;
    }

    /**
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