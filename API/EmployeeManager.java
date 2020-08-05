package VetApp.API;

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
     * @param employee Employee to add.
     * @return int
     */
    public int addEmployee(Employee employee) {
        employee.setEmployeeID(DatabaseManager.addEmployee(employee));
        employees.add(employee);
        return employee.getEmployeeID();
    }

    /**
     * removeEmployee will remove an employee from the ArrayList and the Database.
     * 
     * @param EID Integer EmployeeID of Employee to be removed.
     */
    public void removeEmployee(int EID) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == EID) {
                DatabaseManager.removeEmployee(EID);
                employees.remove(i);
            }
        }
    }

    /**
     * getEmployee will return an employee from a given first and last name.
     * 
     * @param firstName String FirstName of employee to be returned.
     * @param lastName  String LastName of employee to be returned.
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
     * @param employeeID Integer EmployeeID to be returned.
     * @return Employee
     */
    public Employee getEmployee(int employeeID) {
        for (Employee employee : employees)
            if (employeeID == employee.getEmployeeID())
                return employee;

        Employee employee = new Employee();
        employee.setFirstName("ERROR");
        employee.setLastName("ERROR");
        return employee;
    }

    /**
     * @return ArrayList<Employee>
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * updateEmployee will update an employee in the ArrayList and Database with a
     * given EmployeeID.
     * 
     * @param employeeID      Integer EmployeeID of employee to be updated.
     * @param updatedEmployee Employee updated information for employee to be
     *                        updated.
     */
    public void updateEmployee(int employeeID, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employeeID == employees.get(i).getEmployeeID()) {
                updatedEmployee.setEmployeeID(employeeID);
                employees.set(i, updatedEmployee);
                DatabaseManager.updateEmployee(updatedEmployee);
                System.out.println("Updated");
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