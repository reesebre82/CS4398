package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.*;

import API.*;

public class CustomerManagerTester {

    @Test
    public void testGetCustomer() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer(1);

        assertNotEquals("ERROR", customer.getFirstName());
    }

    @Test
    public void testGetCustomer2() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer(-1);

        assertEquals("ERROR", customer.getFirstName());
    }

    @Test
    public void testGetCustomer3() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer("George", "smith");

        assertEquals("George", customer.getFirstName());
    }

    @Test
    public void testGetCustomer4() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer("Reese", "Brendan");

        assertEquals("ERROR", customer.getFirstName());
    }

    @Test
    public void testUpdateCustomer() {
        CustomerManager cm = new CustomerManager();
        Customer customer = cm.getCustomer(1);
        customer.setFirstName("Brendan");
        customer.setLastName("Reese");
        cm.updateCustomer(customer.getCustomerID(), customer);

        Customer newCustomer = cm.getCustomer(1);

        assertEquals("Brendan", newCustomer.getFirstName());
    }
}