package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import System.API.*;

public class EmployeeManagerTester {

    @Test
    public void testGetEmployee() {
        EmployeeManager em = new EmployeeManager();
        Employee employee = em.getEmployee(2);

        assertNotEquals("ERROR", employee.getFirstName());
    }

    @Test
    public void testGetEmployee2() {
        EmployeeManager em = new EmployeeManager();
        Employee employee = em.getEmployee(-1);

        assertEquals("ERROR", employee.getFirstName());
    }

    @Test
    public void testGetEmployee3() {
        EmployeeManager em = new EmployeeManager();
        Employee e = new Employee();
        e.setFirstName("George");
        e.setLastName("smith");
        em.addEmployee(e);
        Employee employee = em.getEmployee("George", "smith");

        assertEquals("George", employee.getFirstName());
    }

    @Test
    public void testGetEmployee4() {
        EmployeeManager em = new EmployeeManager();
        Employee employee = em.getEmployee("", "");

        assertEquals("ERROR", employee.getFirstName());
    }

    @Test
    public void testUpdateCustomer() {
        EmployeeManager em = new EmployeeManager();
        Employee employee = em.getEmployee(2);
        employee.setFirstName("Brendan");
        employee.setLastName("Reese");
        em.updateEmployee(2, employee);

        Employee newEmployee = em.getEmployee(2);

        assertEquals("Brendan", newEmployee.getFirstName());
    }

    @Test
    public void testRemoveEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Jan");
        employee.setLastName("Mela");

        EmployeeManager em = new EmployeeManager();
        em.addEmployee(employee);
        em.removeEmployee(employee.getEmployeeID());

        assertEquals("ERROR", em.getEmployee(employee.getEmployeeID()).getFirstName());
    }
}