
package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import API.*;
import DatabaseSystems.*;

/**
 * DatabaseManagerTester
 */
public class DatabaseManagerTester {

    @Test
    public void testAddEmployee() {
        ArrayList<Employee> employees = DatabaseManager.getEmployeesFromDatabase();

        int largest = -1;
        for (int i = 0; i < employees.size(); i++)
            largest = Math.max(largest, employees.get(i).getEmployeeID());

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Parker");
        employee.setPhoneNumber("(909)909-0909");
        employee.setScheduledHours(0);
        employee.setStartDate("01-13-1998");
        employee.setWeeklyHours(40);
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));

        ArrayList<Employee> newEmployees = DatabaseManager.getEmployeesFromDatabase();

        assertEquals(employees.size() + 1, newEmployees.size());
    }

    @Test
    public void testAddEmployee2() {
        ArrayList<Employee> employees = DatabaseManager.getEmployeesFromDatabase();

        int largest = -1;
        for (int i = 0; i < employees.size(); i++)
            largest = Math.max(largest, employees.get(i).getEmployeeID());

        Employee employee = new Employee();
        employee.setFirstName("Peter");
        employee.setLastName("Johnson");
        employee.setPhoneNumber("(123)321-1234");
        employee.setScheduledHours(0);
        employee.setStartDate("01-13-1998");
        employee.setWeeklyHours(40);
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));

        ArrayList<Employee> newEmployees = DatabaseManager.getEmployeesFromDatabase();
        boolean found = false;
        for (Employee e : newEmployees) {
            if (e.getEmployeeID() == employee.getEmployeeID()) {

                found = true;
                break;
            }
        }

        assertEquals(true, found);
    }

}