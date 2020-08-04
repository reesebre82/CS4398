package API;

import java.util.ArrayList;

import DatabaseSystems.DatabaseManager;

public class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = DatabaseManager.getEmployeesFromDatabase();
    }

    /**
     * addEmployee will add an employee to the ArrayList and Database.
     * 
     * @param employee
     */
    public void addEmployee(Employee employee) {
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));
        employees.add(employee);
    }

    /**
     * removeEmployee will remove an employee from the ArrayList and the Database.
     * 
     * @param EID
     */
    public void removeEmployee(int EID) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == EID) {
                DatabaseManager.removeEmployee(EID);
                employees.remove(EID);
            }
        }
    }

    /**
     * getEmployee will return an employee from a given first and last name.
     * 
     * @param firstName
     * @param lastName
     * @return Employee
     */
    public Employee getEmployee(String firstName, String lastName) {
        for (Employee employee : employees)
            if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName()))
                return employee;

        Employee employee = new Employee();
        employee.setFirstName("ERROR");
        employee.setLastName("ERROR");
        return employee;
    }

    /**
     * getCustomer will return a customer from a given EmployeeID.
     * 
     * @param employeeID
     * @return Employee
     */
    public Employee getCustomer(int employeeID) {
        for (Employee employee : employees)
            if (employeeID == employee.getEmployeeID())
                return employee;

        Employee employee = new Employee();
        employee.setFirstName("ERROR");
        employee.setLastName("ERROR");
        return employee;
    }

    /**
     * updateEmployee will update an employee in the ArrayList and Database with a
     * given EmployeeID.
     * 
     * @param employeeID
     * @param updatedEmployee
     */
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

    /**
     * Close database will update all data on the database and confirm they match
     * with current ArrayList.
     */
    public void closeDatabase() {
        for (Employee employee : employees)
            DatabaseManager.updateEmployee(employee);
    }

    /**
     * @return String
     */
    public String toString() {
        String str = "Employee Data: \n";
        int index = 1;
        for (Employee employee : employees) {
            str += index + ".\n\t";
            str += employee.toString();
            index++;
        }
        return str;
    }
}