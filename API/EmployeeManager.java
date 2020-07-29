package API;

import java.util.ArrayList;

import DatabaseSystems.DatabaseManager;

public class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = DatabaseManager.getEmployeesFromDatabase();
    }

    public void addEmployee(Employee employee) {
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));
        employees.add(employee);
    }

    public Employee getEmployee(String firstName, String lastName) {
        for (Employee employee : employees)
            if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName()))
                return employee;

        Employee employee = new Employee();
        employee.setFirstName("ERROR");
        employee.setLastName("ERROR");
        return employee;
    }

    public Employee getCustomer(int employeeID) {
        for (Employee employee : employees)
            if (employeeID == employee.getEmployeeID())
                return employee;

        Employee employee = new Employee();
        employee.setFirstName("ERROR");
        employee.setLastName("ERROR");
        return employee;
    }

    public void updateEmployee(int employeeID, Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employeeID == employee.getEmployeeID()) {
                updatedEmployee.setEmployeeID(employeeID);
                employees.remove(employee);
                employees.add(updatedEmployee);
                DatabaseManager.updateEmployee(employee);
            }
        }
    }

    public void closeDatabase() {
        for (Employee employee : employees)
            DatabaseManager.updateEmployee(employee);
    }

    public String toString() {
        String str = "Employee Data: \n";
        int index = 1;
        for (Employee employee : employees) {
            str += index + ".\n\t";
            str += "EID: ";
            str += employee.getEmployeeID() + "\n\t";
            str += "First Name: ";
            str += employee.getFirstName() + "\n\t";
            str += "Last Name: ";
            str += employee.getLastName() + "\n\t";
            str += "Phone Number: ";
            str += employee.getPhoneNumber() + "\n\t";
            str += "Start Date: ";
            str += employee.getStartDate() + "\n\t";
            str += "\n\n";

            // Add information for when schedules are created
            index++;
        }
        return str;
    }
}